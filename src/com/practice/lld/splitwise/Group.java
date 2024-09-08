package com.practice.lld.splitwise;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Group {

  private final int id;
  private final String name;
  private final List<User> members;

  private final List<Expense> expenses;

  public Group(int id, String name) {
    this.id = id;
    this.name = name;
    this.members = new CopyOnWriteArrayList<>();
    this.expenses = new CopyOnWriteArrayList<>();
  }

  public void addMember(User member) {
    this.members.add(member);
  }

  public void addExpenses(Expense expense) {
    this.expenses.add(expense);
  }
  
  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public List<User> getMembers() {
    return members;
  }

  public List<Expense> getExpenses() {
    return expenses;
  }
}
