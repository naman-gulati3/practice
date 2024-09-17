package com.practice.lld.coffee_vending_machine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoffeeMachine {
  private final List<Coffee> coffeeList;
  private final Map<String, Ingredient> ingredients;

  public CoffeeMachine() {
    this.coffeeList = new ArrayList<>();
    this.ingredients = new HashMap<>();

    populateCoffeeList();
    populateIngredients();
  }

  private void populateIngredients() {
    ingredients.put("Coffee", new Ingredient("Coffee", 10));
    ingredients.put("Water", new Ingredient("Water", 10));
    ingredients.put("Milk", new Ingredient("Milk", 10));
  }

  private void populateCoffeeList() {
    Map<Ingredient, Integer> espressoRecipe = new HashMap<>();
    espressoRecipe.put(ingredients.get("Coffee"), 1);
    espressoRecipe.put(ingredients.get("Water"), 1);

    Map<Ingredient, Integer> latteRecipe = new HashMap<>();
    espressoRecipe.put(ingredients.get("Coffee"), 1);
    espressoRecipe.put(ingredients.get("Milk"), 2);

    coffeeList.add(new Coffee("espresso", 250, espressoRecipe));
    coffeeList.add(new Coffee("latte", 200, latteRecipe));
  }

  public synchronized Coffee selectCoffee(String coffeeName) {
    for (Coffee coffee : coffeeList) {
      if (coffeeName.equalsIgnoreCase(coffee.getName())) {
        return coffee;
      }
    }
    return null;
  }

  public synchronized void dispenseCoffee(Coffee coffee, Payment payment) {
    if (payment.amount() >= coffee.getPrice()) {
      if (hasEnoughIngredients(coffee)) {
        updateIngredients(coffee);
      }
      float changeToReturn = payment.amount() - coffee.getPrice();
      if (changeToReturn > 0) {
        System.out.printf("Please collect change %s%n", changeToReturn);
      }
    } else {
      System.out.printf(
          "Insufficient payment: %s for coffee %s%n", payment.amount(), coffee.getName());
    }
  }

  public void displayMenu() {
    coffeeList.forEach(
        coffee -> {
          System.out.printf("Coffee: %s, price: %f%n", coffee.getName(), coffee.getPrice());
        });
  }

  private void updateIngredients(Coffee coffee) {
    for (var recipeEntry : coffee.getRecipe().entrySet()) {
      Ingredient ingredient = recipeEntry.getKey();
      int requiredQuantity = recipeEntry.getValue();

      ingredient.updateQuantity(-requiredQuantity);
      if (ingredient.getQuantity() < 3) {
        System.out.printf("Low inventory for %s%n", ingredient.getName());
      }
    }
  }

  private boolean hasEnoughIngredients(Coffee coffee) {
    for (var recipeEntry : coffee.getRecipe().entrySet()) {
      Ingredient ingredient = recipeEntry.getKey();
      Integer requiredQuantity = recipeEntry.getValue();
      if (ingredient.getQuantity() >= requiredQuantity) {
        return true;
      }
    }
    return false;
  }
}
