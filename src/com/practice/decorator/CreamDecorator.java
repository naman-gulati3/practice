package com.practice.decorator;

public class CreamDecorator implements Coffee {

  private final Coffee coffee;

  public CreamDecorator(Coffee coffee) {
    this.coffee = coffee;
  }

  @Override
  public int cost() {
    return coffee.cost() + 7;
  }
}
