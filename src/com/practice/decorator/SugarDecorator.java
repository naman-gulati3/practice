package com.practice.decorator;

public class SugarDecorator implements Coffee {

  private final Coffee coffee;

  public SugarDecorator(Coffee coffee) {
    this.coffee = coffee;
  }

  @Override
  public int cost() {
    return coffee.cost() + 2;
  }
}
