package com.solution.service;

import com.solution.domain.Dish;
import com.solution.domain.IndianMenu;
import com.solution.domain.Ingredient;
import com.solution.domain.MenuCard;
import com.solution.repo.InventoryRepo;
import com.solution.repo.MenuRepo;

import java.util.*;
import java.util.stream.Collectors;

public class ApiService {

  private final InventoryRepo inventroyRepoImpl;
  private final MenuRepo menuRepo;

  public ApiService(final InventoryRepo inventroyRepoImpl, final MenuRepo menuRepo) {
    this.inventroyRepoImpl = inventroyRepoImpl;
    this.menuRepo = menuRepo;
  }

  public void addIngredients(Ingredient ingredient) {
    inventroyRepoImpl.addIngredients(ingredient);
  }


  public List<Ingredient> availableIngredients() {
    return inventroyRepoImpl.getIngredients();
  }


  public List<Dish> addDishes(final List<Dish> dishes) {
    inventroyRepoImpl.addDish(dishes);
    return inventroyRepoImpl.allDishes();
  }

  public void addMenuCards(List<MenuCard> menuCards) {
    menuRepo.addMenuCard(menuCards);
  }

  public List<MenuCard> fetchMenucards() {

    final List<Ingredient> allIngredients = inventroyRepoImpl.getIngredients();
    final Set<String> availableIngredients = getAvailableIngredients(allIngredients);
    final List<MenuCard> menuCards = menuRepo.allMenus();
    //so basically  i have to filter out ingredients not avaialble in menu doshes

    final List<Dish> menuDish = new ArrayList<>();
    final List<Dish> availableDishes = menuCards.stream()
        .map(MenuCard::availableDishes)
        .flatMap(Collection::stream)
        .collect(Collectors.toList());

// TODO  refactor this
    for (Dish dish : availableDishes) {
      final List<Ingredient> ingredients = dish.getIngredients();
      boolean isAvailable = true;
      for (Ingredient ingredient : ingredients) {
        if (!availableIngredients.contains(ingredient.getName())) {
          isAvailable = false;
          break;
        }
      }
      if (isAvailable) {
        menuDish.add(dish);
      }
    }

    final MenuCard availableMenuWithDishes = new IndianMenu(inventroyRepoImpl, menuDish);
    return Arrays.asList(availableMenuWithDishes);
  }

  /**
   * 1,2,3  dishesh
   * 1,2 ingredients av not for 3
   */
  public String orderDish(final String dishName, final int quantity) {
    final List<MenuCard> menuCards = fetchMenucards(); // this return only those dishesh for which we have ingredients
    final List<Dish> availableDishes = menuCards.stream().map(MenuCard::disheshInMenu).flatMap(Collection::stream).collect(Collectors.toList());

    final boolean isDishAvailable = availableDishes.stream().anyMatch(dish -> dish.getName().equalsIgnoreCase(dishName));
    if (!isDishAvailable) {
      throw new RuntimeException("Dish is not available right now! Please try after some time");
    }

    final List<Ingredient> availableIngredients =
        availableDishes.stream().map(Dish::getIngredients).flatMap(Collection::stream).collect(Collectors.toList());

    final Float totalQuantityOfIngredientAvailable = availableIngredients.stream().map(Ingredient::getQuantity).reduce(Float::sum).get();

    final List<Dish> dishesCanBeprepared = availableDishes.stream().filter(dish -> dish.getName().equalsIgnoreCase(dishName)).collect(Collectors.toList());

    if (totalQuantityOfIngredientAvailable * quantity !=  totalQuantityOfIngredientAvailable){
      throw new RuntimeException("only " + dishesCanBeprepared.size() + " dish can be prepared");
    }

    inventroyRepoImpl.removeDish(dishName, quantity);

    return "order successfully placed!";
  }

  private Set<String> getAvailableIngredients(final List<Ingredient> allIngredients) {
    return allIngredients.stream()
        .filter(ingredient -> ingredient.getQuantity() > 0.0)
        .map(Ingredient::getName)
        .collect(Collectors.toSet());
  }

}
