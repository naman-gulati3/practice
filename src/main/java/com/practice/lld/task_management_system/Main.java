package com.practice.lld.task_management_system;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Main {

  public static void main(String[] args) {
    TaskManager taskManager = TaskManager.getInstance();
    User user1 = new User("1", "naman", "naman.gulati@xyz.com");

    Task task1 = new Task();
    task1.setTitle("task1");
    task1.setAssignedUser(user1);
    task1.setStatus(Status.PENDING);
    task1.setScheduledTime(Date.from(Instant.now().plus(4, ChronoUnit.DAYS)));
    task1.setDescription("task1 description");
    task1.setId("1");

    taskManager.createTask(task1);
    taskManager.markTaskAsComplete("1");
    System.out.println(task1);
  }
}
