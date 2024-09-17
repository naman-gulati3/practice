package com.practice.lld.vending_machine;

public class IdleVendingMachineState implements VendingeMachineState {
  private final VendingMachine vendingMachine;

  public IdleVendingMachineState(VendingMachine vendingMachine) {
    this.vendingMachine = vendingMachine;
  }

  @Override
  public void selectProduct(Product product) {
    if (vendingMachine.inventory.isAvailable(product)) {
      vendingMachine.setSelectedProduct(product);
      vendingMachine.setCurrentState(vendingMachine.getReadyState());
      System.out.println("Selected product " + product);
    } else {
      System.out.println("Product not available");
    }
  }

  @Override
  public void insertCount(Coin coin) {}

  @Override
  public void insertNote(Note note) {}

  @Override
  public void dispenseProduct() {}

  @Override
  public void returnChange() {}
}
