package com.practice.lld.atm;

public class CashDispenser {
  private float cashAvailable;

  public CashDispenser(float cashAvailable) {
    this.cashAvailable = cashAvailable;
  }

  public synchronized void dispenseCash(float amount) {
    if (amount > cashAvailable) {
      throw new IllegalArgumentException("Insufficient balance");
    }
    cashAvailable -= amount;
    System.out.println("Cash dispensed " + amount);
  }
}
