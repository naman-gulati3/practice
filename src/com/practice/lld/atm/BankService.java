package com.practice.lld.atm;

public interface BankService {

  boolean registerAccount(String accountNumber, float initialBalance);

  Account getAccount(String accountNumber);
  void transact(Transaction transaction);
}
