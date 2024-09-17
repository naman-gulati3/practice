package com.practice.lld.splitwise;

import com.practice.lld.splitwise.split.EqualSplit;
import com.practice.lld.splitwise.split.PercentageSplit;
import com.practice.lld.splitwise.split.Split;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class SplitWiseService {

  private static final String TXN_PREFIX = "TXN";

  private static final AtomicInteger txnCounter = new AtomicInteger(0);
  private static SplitWiseService instance;

  private final Map<Integer, User> users;

  private final Map<Integer, Group> groups;

  public static synchronized SplitWiseService getInstance() {
    if (instance == null) {
      instance = new SplitWiseService();
    }
    return instance;
  }

  public SplitWiseService() {
    this.users = new ConcurrentHashMap<>();
    this.groups = new ConcurrentHashMap<>();
  }

  public void addUser(User user) {
    this.users.put(user.getId(), user);
  }

  public void addGroup(Group group) {
    this.groups.put(group.getId(), group);
  }

  public void addExpense(int groupId, Expense expense) {
    if (!this.groups.containsKey(groupId)) {
      throw new IllegalArgumentException("Group with id: %s does not exist".formatted(groupId));
    }

    this.groups.get(groupId).addExpenses(expense);
    splitExpense(expense);
    updateBalances(expense);
  }

  private void updateBalances(Expense expense) {
    for (Split split : expense.getSplits()) {
      User paidBy = expense.getPaidBy();
      User paidFor = split.getUser();

      double amount = split.getAmount();

      if (!paidBy.equals(paidFor)) {
        updateBalance(paidBy, paidFor, amount);
        updateBalance(paidFor, paidBy, -amount);
      }
    }
  }

  private void updateBalance(User user1, User user2, double amount) {
    String key = getBalanceKey(user1, user2);
    user1.getBalances().put(key, user1.getBalances().getOrDefault(key, 0.0) + amount);
  }

  private String getBalanceKey(User user1, User user2) {
    return user1.getId() + ":" + user2.getId();
  }

  public void splitExpense(Expense expense) {
    double totalAmount = expense.getAmount();
    double perMemberSplit = totalAmount / expense.getSplits().size();

    for (Split split : expense.getSplits()) {
      if (split instanceof EqualSplit) {
        split.setAmount(perMemberSplit);
      } else if (split instanceof PercentageSplit percentageSplit) {
        split.setAmount((percentageSplit.getPercentage() / 100.0) * percentageSplit.getAmount());
      }
    }
  }

  public void settleBalances(Integer user1Id, Integer user2Id) {
    User user1 = this.users.get(user1Id);
    User user2 = this.users.get(user2Id);

    if (user1 != null && user2 != null) {
      String key = getBalanceKey(user1, user2);
      double balance = user1.getBalances().getOrDefault(key, 0.0);

      if (balance > 0) {
        createTransaction(balance, user1, user2);
        user1.getBalances().put(key, 0.0);
        user2.getBalances().put(getBalanceKey(user2, user1), 0.0);
      } else if (balance < 0) {
        createTransaction(balance, user2, user1);
        user2.getBalances().put(key, 0.0);
        user1.getBalances().put(getBalanceKey(user1, user2), 0.0);
      }
    }
  }

  private void createTransaction(double balance, User user1, User user2) {
    Transaction txn = new Transaction(balance, user1, user2, createTxnId());
    // process txn
  }

  private String createTxnId() {
    return TXN_PREFIX + "_" + txnCounter.incrementAndGet();
  }
}
