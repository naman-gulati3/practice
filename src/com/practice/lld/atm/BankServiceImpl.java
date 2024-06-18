package com.practice.lld.atm;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BankServiceImpl implements BankService {
  private  final Map<String, Account> accounts = new ConcurrentHashMap<>();
  private static BankServiceImpl instance;

  private BankServiceImpl() {
  }

  public BankServiceImpl getInstance() {
    if(instance == null) {
      instance = new BankServiceImpl();
    }
    return instance;
  }

  @Override
  public synchronized boolean registerAccount(String accountNumber, float initialBalance) {
    accounts.put(accountNumber, new Account(accountNumber, initialBalance));
    return true;
  }

  @Override
  public Account getAccount(String accountNumber) {
    return accounts.get(accountNumber);
  }

  @Override
  public void transact(Transaction transaction) {
    transaction.execute();
  }
}
