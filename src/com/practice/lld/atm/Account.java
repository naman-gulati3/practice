package com.practice.lld.atm;

public class Account {

  private final String accountNumber;

  private float balance;

  public Account(String accountNumber, float balance) {
    this.accountNumber = accountNumber;
    this.balance = balance;
  }


  public String getAccountNumber() {
    return accountNumber;
  }

  public float getBalance() {
    return balance;
  }

  public void setBalance(float balance) {
    this.balance = balance;
  }

  public void debit(float amount) {
    this.balance -= amount;
  }

  public void credit(float amount) {
    this.balance += amount;
  }
}
