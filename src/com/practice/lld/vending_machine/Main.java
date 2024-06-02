package com.practice.lld.vending_machine;

public class Main {

  public static void main(String[] args) {
    VendingMachine vendingMachine = VendingMachine.getInstance();

    Product coke = new Product("Coke", 40);
    Product chips = new Product("Chips", 20);
    Product chocolate = new Product("Chocolate", 10);

    vendingMachine.inventory.addProduct(coke, 5);
    vendingMachine.inventory.addProduct(chips, 2);
    vendingMachine.inventory.addProduct(chocolate, 3);

    vendingMachine.selectProduct(coke);

    vendingMachine.insertNote(Note.FIFTY_RUPEES);

    vendingMachine.dispenseProduct();

    vendingMachine.returnChange();
  }
}
