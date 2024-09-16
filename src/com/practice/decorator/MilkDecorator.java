package com.practice.decorator;

public class MilkDecorator implements Coffee {

  private final Coffee coffee;

  public MilkDecorator(Coffee coffee) {
    this.coffee = coffee;
  }

  @Override
  public int cost() {
    return coffee.cost() + 10;
  }
}
