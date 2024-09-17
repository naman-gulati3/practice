package com.practice.lld.splitwise;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class User {

  private final int id;
  private final String name;
  private final String email;

  private final Map<String, Double> balances;

  public User(int id, String name, String email) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.balances = new ConcurrentHashMap<>();
  }

  public void addExpense(String expenseId, double amount) {
    this.balances.put(expenseId, amount);
  }

  public Map<String, Double> getBalances() {
    return balances;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }
}
