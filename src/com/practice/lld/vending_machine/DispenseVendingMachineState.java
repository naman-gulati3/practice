package com.practice.lld.vending_machine;

public class DispenseVendingMachineState implements VendingeMachineState {
  private final VendingMachine vendingMachine;

  public DispenseVendingMachineState(VendingMachine vendingMachine) {
    this.vendingMachine = vendingMachine;
  }

  @Override
  public void selectProduct(Product product) {

  }

  @Override
  public void insertCount(Coin coin) {

  }

  @Override
  public void insertNote(Note note) {

  }

  @Override
  public void dispenseProduct() {
    vendingMachine.setCurrentState(vendingMachine.getReadyState());

    Product product = vendingMachine.getSelectedProduct();
    vendingMachine.inventory.updateQuantity(product, vendingMachine.inventory.getQuantity(product) - 1);
    System.out.println("Product dispenses: " + product.name());
    vendingMachine.setCurrentState(vendingMachine.getReturnState());
  }

  @Override
  public void returnChange() {

  }
}
