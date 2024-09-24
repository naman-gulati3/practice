package com.practice.machine_coding.flipkart_daily.dto;

public class User {

  private final String name;
  private final String address;
  private Wallet wallet;

  public User(String name, String address) {
    this.name = name;
    this.address = address;
    this.wallet = new Wallet(0);
  }

  public Wallet getWallet() {
    return wallet;
  }

  public void addMoneyToWallet(float amount) {
    this.wallet = new Wallet(amount + this.wallet.getAmount());
  }

  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }
}
