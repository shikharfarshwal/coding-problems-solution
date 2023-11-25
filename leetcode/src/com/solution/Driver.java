package com.solution;

import com.solution.domain.Dish;
import com.solution.domain.IndianMenu;
import com.solution.domain.Ingredient;
import com.solution.domain.MenuCard;
import com.solution.repo.InventoryRepo;
import com.solution.repo.InventroyRepoImpl;
import com.solution.repo.MenuRepo;
import com.solution.repo.MenuRepoImpl;
import com.solution.service.ApiService;

import java.util.Arrays;
import java.util.List;

public class Driver {


  public static void main(String[] args) {
    InventoryRepo inventoryRepo = new InventroyRepoImpl();
    MenuRepo menuRepo = new MenuRepoImpl();
    ApiService apiService = new ApiService(inventoryRepo, menuRepo);

    final Ingredient ingredient1 = new Ingredient("paneer", 1f);
    final Ingredient ingredient2 = new Ingredient("onion", 1f);
    final Ingredient ingredient3 = new Ingredient("matar", 0f);
    final Ingredient ingredient4 = new Ingredient("x", 1f);
    final Ingredient ingredient5 = new Ingredient("y", 0f);


    //API 1
    apiService.addIngredients(ingredient1);
    apiService.addIngredients(ingredient2);
    apiService.addIngredients(ingredient3);
    apiService.addIngredients(ingredient4);
    apiService.addIngredients(ingredient5);

    //API 2
    final List<Ingredient> ingredients = apiService.availableIngredients();

    System.out.println("available ingredients are - {}" + ingredients);

    System.out.println();
    final Dish dish1 = new Dish("paneer bhuji", "indian", Arrays.asList(ingredient1, ingredient2));
    final Dish dish2 = new Dish("matar paneer", "indian", Arrays.asList(ingredient1, ingredient2, ingredient3));

    final Dish dishFlipkart = new Dish("flipkart", "indian", Arrays.asList(ingredient4, ingredient5));

    //API 3
    final List<Dish> dishes = apiService.addDishes(Arrays.asList(dish1, dish2, dishFlipkart));
    System.out.println();
    System.out.println("available dishes are - {}" + dishes);
    System.out.println();

    MenuCard menuCard = new IndianMenu(inventoryRepo, dishes);

    // API 4
    apiService.addMenuCards(Arrays.asList(menuCard));

    //API 5
    final List<MenuCard> menuCards = apiService.fetchMenucards();

    System.out.println("all menus except matar paneer dish as matar quantity is 0  -{}" + menuCards);

    //API 6
    final String orderStatus = apiService.orderDish("flipkart", 1);

    System.out.println();
    System.out.println(orderStatus);

    final List<MenuCard> menuCardsAfterOrder = apiService.fetchMenucards();

    System.out.println("menu card after order" + menuCardsAfterOrder);
  }
}
