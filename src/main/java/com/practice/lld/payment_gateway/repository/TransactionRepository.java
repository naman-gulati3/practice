package com.practice.lld.payment_gateway.repository;

import com.practice.lld.payment_gateway.dto.Transaction;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TransactionRepository {
  Map<UUID, Transaction> transactions = new HashMap<>();

  public void addTransaction(Transaction transaction) {
    this.transactions.put(transaction.getId(), transaction);
  }
}
