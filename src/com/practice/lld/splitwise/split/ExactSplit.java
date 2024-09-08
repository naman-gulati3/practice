package com.practice.lld.splitwise.split;

import com.practice.lld.splitwise.User;

public class ExactSplit extends Split {

  public ExactSplit(User user, double amount) {
    super(user);
    this.amount = amount;
  }

  @Override
  public double getAmount() {
    return this.amount;
  }
}
