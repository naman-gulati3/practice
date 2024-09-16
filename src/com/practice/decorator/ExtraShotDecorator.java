package com.practice.decorator;

public class ExtraShotDecorator implements Coffee {

  private final Coffee coffee;

  public ExtraShotDecorator(Coffee coffee) {
    this.coffee = coffee;
  }

  @Override
  public int cost() {
    return coffee.cost() + 5;
  }
}
