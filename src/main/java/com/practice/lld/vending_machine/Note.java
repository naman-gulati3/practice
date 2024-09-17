package com.practice.lld.vending_machine;

public enum Note {
  FIVE_RUPEES(5),
  TEN_RUPEES(10),
  TWENTY_RUPEES(20),
  FIFTY_RUPEES(50),
  HUNDRED_RUPEES(100),
  TWO_HUNDRED_RUPEES(200),
  FIVE_HUNDRED_RUPEES(500),
  THOUSAND_RUPEES(1000),
  TWO_THOUSAND_RUPEES(2000);

  private final int value;

  Note(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}
