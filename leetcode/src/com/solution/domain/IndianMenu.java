package com.solution.domain;

import com.solution.repo.InventoryRepo;

import java.util.List;

public class IndianMenu implements MenuCard {

  private final List<Dish> dishes;
  InventoryRepo inventoryRepo;

  public IndianMenu(final InventoryRepo inventoryRepo, List<Dish> dishes) {
    this.inventoryRepo = inventoryRepo;
    this.dishes = dishes;
  }

  @Override
  public List<Dish> availableDishes() {
    return inventoryRepo.allDishes();
  }

  @Override
  public List<Dish> disheshInMenu() {
    return dishes;
  }

  public List<Dish> getDishes() {
    return dishes;
  }

  public InventoryRepo getInventoryRepo() {
    return inventoryRepo;
  }

  @Override
  public String toString() {
    return "IndianMenu{" +
        "dishes=" + dishes +
        '}';
  }
}
