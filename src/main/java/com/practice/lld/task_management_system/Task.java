package com.practice.lld.task_management_system;

import java.util.Date;

public class Task {

  private String id;
  private String title;
  private String description;
  private int priority;
  private Date scheduledTime;

  private Status status;

  private User assignedUser;

  public Task() {}

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public int getPriority() {
    return priority;
  }

  public Date getScheduledTime() {
    return scheduledTime;
  }

  public String getId() {
    return id;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public Status getStatus() {
    return status;
  }

  public User getAssignedUser() {
    return assignedUser;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setPriority(int priority) {
    this.priority = priority;
  }

  public void setScheduledTime(Date scheduledTime) {
    this.scheduledTime = scheduledTime;
  }

  public void setAssignedUser(User assignedUser) {
    this.assignedUser = assignedUser;
  }

  @Override
  public String toString() {
    return "Task{"
        + "id='"
        + id
        + '\''
        + ", title='"
        + title
        + '\''
        + ", description='"
        + description
        + '\''
        + ", priority="
        + priority
        + ", scheduledTime="
        + scheduledTime
        + ", status="
        + status
        + ", assignedUser="
        + assignedUser
        + '}';
  }
}
