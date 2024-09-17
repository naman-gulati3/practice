package com.practice.lld.splitwise.split;

import com.practice.lld.splitwise.User;

public class PercentageSplit extends Split {

  private final double percentage;

  public PercentageSplit(User user, double percentage) {
    super(user);
    this.percentage = percentage;
  }

  @Override
  public double getAmount() {
    return this.amount;
  }

  public double getPercentage() {
    return this.percentage;
  }
}
