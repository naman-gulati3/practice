package com.practice.lld.task_management_system;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class TaskManager {
  private static TaskManager instance;
  private Map<String, Task> tasks;
  private Map<String, List<Task>> userTasks;

  private TaskManager() {
    this.tasks = new ConcurrentHashMap<>();
    this.userTasks = new ConcurrentHashMap<>();
  }

  public static synchronized TaskManager getInstance() {
    if(instance == null) {
      instance = new TaskManager();
    }
    return instance;
  }

  public void createTask(Task task) {
    tasks.put(task.getId(), task);
    assignTaskToUser(task.getAssignedUser(), task);
  }

  public void updateTask(Task updatedTask) {
    Task existingTask = tasks.get(updatedTask.getId());
    if(existingTask != null) {
      synchronized (existingTask) {
        existingTask.setStatus(updatedTask.getStatus());
        existingTask.setDescription(updatedTask.getDescription());
        existingTask.setPriority(updatedTask.getPriority());
        existingTask.setScheduledTime(updatedTask.getScheduledTime());
        existingTask.setTitle(updatedTask.getTitle());

        User previousUser = existingTask.getAssignedUser();
        User newUser = updatedTask.getAssignedUser();

        if(!previousUser.equals(newUser)) {
          unassignTaskFromUser(previousUser, existingTask);
          assignTaskToUser(newUser, existingTask);
        }
      }
    }
  }

  private void assignTaskToUser(User user, Task task) {
    userTasks.computeIfAbsent(user.getId(),  k -> new CopyOnWriteArrayList<>()).add(task);
  }

  public List<Task> filterTasks(Status status, int priority, Date startData, Date endDate) {
    List<Task> filteredTasks = new ArrayList<>();
    for(Task task : tasks.values()) {
      if(status.equals(task.getStatus()) &&
          task.getPriority() == priority &&
          task.getScheduledTime().compareTo(startData) >= 0 &&
          task.getScheduledTime().compareTo(endDate) <= 0) {
            filteredTasks.add(task);
      }
    }
    return filteredTasks;
  }

  public void deleteTask(Task task) {
    Task removedTask = tasks.remove(task.getId());
    if(removedTask != null) {
      unassignTaskFromUser(task.getAssignedUser(), task);
    }
  }

  private void unassignTaskFromUser(User user, Task task) {
    List<Task> tasksForUser = userTasks.get(user.getId());
    if(tasksForUser != null) {
      tasksForUser.remove(task);
    }
  }

  public void markTaskAsComplete(String taskId) {
    Task task = tasks.remove(taskId);
    if(task != null) {
      task.setStatus(Status.COMPLETE);
    }
  }
}