package com.practice.lld.task_management_system;

import java.time.Instant;

public class Task {
  private final String title;
  private final String description;
  private final int priority;
  private final Instant scheduledTime;

  public Task(String title, String description, int priority, Instant scheduledTime) {
    this.title = title;
    this.description = description;
    this.priority = priority;
    this.scheduledTime = scheduledTime;
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public int getPriority() {
    return priority;
  }

  public Instant getScheduledTime() {
    return scheduledTime;
  }
}
