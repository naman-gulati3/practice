package com.practice.lld.vending_machine;

public enum Coin {
  ONE_RUPEE(1),
  TWO_RUPEES(2),
  FIVE_RUPEES(5),
  TEN_RUPEES(10);

  private final int value;

  Coin(int value) {
    this.value = value;
  }

  public int getValue() {
    return this.value;
  }
}
