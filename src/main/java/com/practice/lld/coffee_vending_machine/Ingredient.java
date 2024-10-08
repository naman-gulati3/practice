package com.practice.lld.coffee_vending_machine;

public class Ingredient {
  private final String name;
  private int quantity;

  public Ingredient(String name, int quantity) {
    this.name = name;
    this.quantity = quantity;
  }

  public synchronized void updateQuantity(int amount) {
    this.quantity += amount;
  }

  public String getName() {
    return name;
  }

  public int getQuantity() {
    return quantity;
  }
}
