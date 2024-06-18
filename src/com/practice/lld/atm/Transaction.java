package com.practice.lld.atm;

public abstract class Transaction {
  protected final String transactionId;
  protected final float amount;

  protected final Account account;

  public Transaction(String transactionId, float amount, Account account) {
    this.transactionId = transactionId;
    this.amount = amount;
    this.account = account;
  }

  public abstract void execute();
}
