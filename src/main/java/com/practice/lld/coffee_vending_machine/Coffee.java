package com.practice.lld.coffee_vending_machine;

import java.util.Map;

public class Coffee {

  private final String name;
  private final float price;
  private final Map<Ingredient, Integer> recipe;

  public Coffee(String name, float price, Map<Ingredient, Integer> recipe) {
    this.name = name;
    this.price = price;
    this.recipe = recipe;
  }

  public String getName() {
    return name;
  }

  public float getPrice() {
    return price;
  }

  public Map<Ingredient, Integer> getRecipe() {
    return recipe;
  }
}
