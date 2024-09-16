package com.practice.decorator;

public class CoffeeMachine {

  public static void main(String[] args) {
    Coffee coffee = new BaseCoffee();
    System.out.println(coffee.cost());
    Coffee coffeeWithMilk = new MilkDecorator(coffee);
    System.out.println(coffeeWithMilk.cost());

    Coffee coffeeWithMilkAndSugar = new SugarDecorator(coffeeWithMilk);
    System.out.println(coffeeWithMilkAndSugar.cost());
  }
}
