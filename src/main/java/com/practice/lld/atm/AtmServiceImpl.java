package com.practice.lld.atm;

import java.time.Instant;
import java.util.concurrent.atomic.AtomicInteger;

public class AtmServiceImpl implements AtmService {
  private final BankService bankService;
  private final CashDispenser cashDispenser;

  private static final AtomicInteger transactionCounter = new AtomicInteger(0);

  public AtmServiceImpl(BankService bankService, CashDispenser cashDispenser) {
    this.cashDispenser = cashDispenser;
    this.bankService = bankService;
  }

  @Override
  public void withdraw(String accountNumber, float amount) {
    Account account = bankService.getAccount(accountNumber);
    Transaction transaction = new WithdrawTransaction(getTransactionId(), amount, account);
    bankService.transact(transaction);
    cashDispenser.dispenseCash(amount);
  }

  @Override
  public float checkBalance(String accountNumber) {
    Account account = bankService.getAccount(accountNumber);
    return account.getBalance();
  }

  @Override
  public void deposit(String accountNumber, float amount) {
    Account account = bankService.getAccount(accountNumber);
    Transaction transaction = new DepositTransaction(getTransactionId(), amount, account);
    transaction.execute();
    cashDispenser.dispenseCash(amount);
  }

  private String getTransactionId() {
    long transactionNumber = transactionCounter.incrementAndGet();
    long epoch = Instant.now().toEpochMilli();
    return String.format("%s_%s", transactionNumber, epoch);
  }
}
