package com.practice.lld.atm;

public class WithdrawTransaction extends  Transaction {
 public WithdrawTransaction(String transactionId, float amount, Account account) {
   super(transactionId, amount, account);
 }
  @Override
  public void execute() {
   account.debit(amount);
  }
}
