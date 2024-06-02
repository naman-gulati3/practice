package com.practice.lld.vending_machine;

public class ReturnVendingMachineState implements VendingeMachineState{
  private VendingMachine vendingMachine;

  public ReturnVendingMachineState(VendingMachine vendingMachine) {
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

  }

  @Override
  public void returnChange() {
    double change = vendingMachine.getTotalPayment() - vendingMachine.getSelectedProduct().price();
    if(change > 0) {
      vendingMachine.resetPayment();
      System.out.println("Returned change: " + change);
    } else {
      System.out.println("Nothing to return");
    }

    vendingMachine.resetSelectedProduct();
    vendingMachine.setCurrentState(vendingMachine.getIdleState());
  }
}
