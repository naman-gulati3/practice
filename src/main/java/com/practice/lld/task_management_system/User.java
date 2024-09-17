package com.practice.lld.task_management_system;

import java.util.List;

public class User {

  private final String id;
  private final String name;
  private final String email;

  private List<Task> assignedTasks;

  public User(String id, String name, String email) {
    this.id = id;
    this.name = name;
    this.email = email;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public List<Task> getAssignedTasks() {
    return assignedTasks;
  }

  public void setAssignedTasks(List<Task> assignedTasks) {
    this.assignedTasks = assignedTasks;
  }
}
