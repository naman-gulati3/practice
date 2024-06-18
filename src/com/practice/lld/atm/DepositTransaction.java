package com.practice.lld.atm;

public class DepositTransaction extends Transaction{

  public DepositTransaction(String transactionId, float amount, Account account) {
    super(transactionId, amount, account);
  }

  @Override
  public void execute() {
    account.credit(amount);
  }
}
