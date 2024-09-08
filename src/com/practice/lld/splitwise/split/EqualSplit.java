package com.practice.lld.splitwise.split;

import com.practice.lld.splitwise.User;

public class EqualSplit extends Split {

  public EqualSplit(User user) {
    super(user);
  }

  @Override
  public double getAmount() {
    return this.amount;
  }
}
