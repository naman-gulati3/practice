package com.practice.lld.atm;

public class Card {
  private final int pin;
  private final String cardNumber;

  public Card(int pin, String cardNumber) {
    this.pin = pin;
    this.cardNumber = cardNumber;
  }

  public int getPin() {
    return pin;
  }

  public String getCardNumber() {
    return cardNumber;
  }
}
