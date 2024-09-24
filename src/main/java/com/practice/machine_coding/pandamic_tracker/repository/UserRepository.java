package com.practice.machine_coding.pandamic_tracker.repository;

import com.practice.machine_coding.pandamic_tracker.dto.User;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class UserRepository {

  private final Map<String, User> users;

  public UserRepository() {
    this.users = new ConcurrentHashMap<>();
  }

  public Optional<User> getUserByPhoneNumber(String phoneNumber) {
    return Optional.ofNullable(this.users.get(phoneNumber));
  }

  public void setUser(User user) {
    this.users.put(user.getPhoneNumber(), user);
  }
}
