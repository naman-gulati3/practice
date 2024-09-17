package com.practice.lld.splitwise;

import com.practice.lld.splitwise.split.Split;
import java.util.ArrayList;
import java.util.List;

public class Expense {

  private final int id;
  private final double amount;
  private final String description;
  private final User paidBy;

  private final List<Split> splits;

  public Expense(int id, double amount, String description, User paidBy) {
    this.id = id;
    this.amount = amount;
    this.description = description;
    this.paidBy = paidBy;
    this.splits = new ArrayList<>();
  }

  public void addSplit(Split split) {
    this.splits.add(split);
  }

  public int getId() {
    return id;
  }

  public double getAmount() {
    return amount;
  }

  public String getDescription() {
    return description;
  }

  public User getPaidBy() {
    return paidBy;
  }

  public List<Split> getSplits() {
    return splits;
  }
}
