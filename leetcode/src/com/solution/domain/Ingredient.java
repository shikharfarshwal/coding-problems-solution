package com.solution.domain;

public class Ingredient {

  private final String name;
  private final Float quantity;

  public Ingredient(final String name, final Float quantity) {
    this.name = name;
    this.quantity = quantity;
  }


  public String getName() {
    return name;
  }

  public Float getQuantity() {
    return quantity;
  }

  @Override
  public String toString() {
    return "Ingredient{" +
        "name='" + name + '\'' +
        ", quantity=" + quantity +
        '}';
  }
}
