package com.solution.repo;

import com.solution.domain.Dish;
import com.solution.domain.Ingredient;

import java.util.List;

public interface InventoryRepo {

  void addIngredients(Ingredient ingredient);

  List<Ingredient> getIngredients();

  void addDish(List<Dish> dish);

  void removeDish(String dishName, int quantity);

  List<Dish> allDishes();
}
