package com.solution.domain;

import java.util.List;

public class Dish {

  private String name;
  private String type;
  private List<Ingredient> ingredients;

  public Dish(final String name, final String type, final List<Ingredient> ingredients) {
    this.name = name;
    this.type = type;
    this.ingredients = ingredients;
  }


  public String getName() {
    return name;
  }

  public String getType() {
    return type;
  }

  public List<Ingredient> getIngredients() {
    return ingredients;
  }

  public void setIngredients(List<Ingredient> ingredients) {
    this.ingredients = ingredients;
  }

  @Override
  public String toString() {
    return "Dish{" +
        "name='" + name + '\'' +
        ", type='" + type + '\'' +
        ", ingredients=" + ingredients +
        '}';
  }
}
