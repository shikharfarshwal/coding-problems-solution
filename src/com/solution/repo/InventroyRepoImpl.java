package com.solution.repo;

import com.solution.domain.Dish;
import com.solution.domain.Ingredient;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InventroyRepoImpl implements InventoryRepo {

  public List<Ingredient> ingredients = new ArrayList<>();
  public List<Dish> dishes = new ArrayList<>();

  // no id
  @Override
  public void addIngredients(final Ingredient ingredient) {
    ingredients.add(ingredient);
  }

  @Override
  public List<Ingredient> getIngredients() {
    return ingredients;
  }

  @Override
  public void addDish(final List<Dish> dish) {
    dishes.addAll(dish);
  }

  @Override
  public void removeDish(final String dishName, final int quantity) {
    final List<Dish> avaialbleDish = dishes.stream().filter(dish -> dish.getName().equalsIgnoreCase(dishName))
        .collect(Collectors.toList());

    final List<Ingredient> ingredients = avaialbleDish.get(0).getIngredients();

    final List<Ingredient> newStock = new ArrayList<>();
    for (final Ingredient ingredient : ingredients) {
      final float available = ingredient.getQuantity() - quantity;
      newStock.add(new Ingredient(ingredient.getName(), available));
    }

    avaialbleDish.get(0).setIngredients(newStock);


  }


  @Override
  public List<Dish> allDishes() {
    return dishes;
  }


}
