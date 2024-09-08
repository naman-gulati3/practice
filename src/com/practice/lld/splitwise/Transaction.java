package com.practice.lld.splitwise;

public class Transaction {

  private final double amount;
  private final User sender;
  private final User receiver;

  private final String id;

  public Transaction(double amount, User sender, User receiver, String id) {
    this.amount = amount;
    this.sender = sender;
    this.receiver = receiver;
    this.id = id;
  }
}
