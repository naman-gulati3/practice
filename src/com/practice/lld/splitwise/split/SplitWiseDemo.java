package com.practice.lld.splitwise.split;

import com.practice.lld.splitwise.Expense;
import com.practice.lld.splitwise.Group;
import com.practice.lld.splitwise.SplitWiseService;
import com.practice.lld.splitwise.User;
import java.util.List;

public class SplitWiseDemo {

  public static void main(String[] args) {
    SplitWiseService service = SplitWiseService.getInstance();
    User user1 = new User(1, "naman", "naman.gulati3@gmail.com");
    User user2 = new User(2, "somewhere", "somewhere@gmail.com");
    User user3 = new User(3, "random", "random@xyz.com");

    service.addUser(user1);
    service.addUser(user2);
    service.addUser(user3);

    Group group = new Group(1, "Goa trip");
    group.addMember(user1);
    group.addMember(user2);
    group.addMember(user3);

    service.addGroup(group);
    Expense expense = new Expense(1, 300.0, "Flights", user1);

    Split split1 = new EqualSplit(user1);
    Split split2 = new EqualSplit(user2);
    Split split3 = new EqualSplit(user3);

    expense.addSplit(split1);
    expense.addSplit(split2);
    expense.addSplit(split3);

    service.addExpense(group.getId(), expense);
    
    // settle
    service.settleBalances(user1.getId(), user2.getId());
    service.settleBalances(user1.getId(), user3.getId());

    for (User user : List.of(user1, user2, user1)) {
      for (var entry : user.getBalances().entrySet()) {
        System.out.println("Balance with user" + entry.getKey() + ": " + entry.getValue());
      }
    }
  }
}
