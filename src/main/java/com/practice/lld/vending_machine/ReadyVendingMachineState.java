package com.practice.lld.vending_machine;

public class ReadyVendingMachineState implements VendingeMachineState {
  private final VendingMachine vendingMachine;

  public ReadyVendingMachineState(VendingMachine vendingMachine) {
    this.vendingMachine = vendingMachine;
  }

  @Override
  public void selectProduct(Product product) {}

  @Override
  public void insertCount(Coin coin) {
    vendingMachine.insertCoin(coin);
    checkPaymentStatus();
  }

  @Override
  public void insertNote(Note note) {
    vendingMachine.addNote(note);
    checkPaymentStatus();
  }

  @Override
  public void dispenseProduct() {}

  @Override
  public void returnChange() {
    double change = vendingMachine.getTotalPayment() - vendingMachine.getSelectedProduct().price();
    if (change > 0) {
      vendingMachine.resetPayment();
      ;
    } else {
      System.out.println("No change to return");
    }

    vendingMachine.setCurrentState(vendingMachine.getIdleState());
  }

  public void checkPaymentStatus() {
    if (vendingMachine.getTotalPayment() >= vendingMachine.getSelectedProduct().price()) {
      vendingMachine.setCurrentState(vendingMachine.getDispenseState());
    }
  }
}
