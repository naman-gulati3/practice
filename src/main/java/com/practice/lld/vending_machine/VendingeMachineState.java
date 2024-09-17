package com.practice.lld.vending_machine;

public interface VendingeMachineState {
  void selectProduct(Product product);

  void insertCount(Coin coin);

  void insertNote(Note note);

  void dispenseProduct();

  void returnChange();
}
