package com.practice.decorator;

public class BaseCoffee implements Coffee {

  @Override
  public int cost() {
    return 100;
  }
}
