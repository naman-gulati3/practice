package com.practice.machine_coding.develper_social_media.repository;

import com.practice.machine_coding.develper_social_media.dto.User;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class UserRepository {

  private final Map<String, User> usersByName;

  public UserRepository() {
    this.usersByName = new ConcurrentHashMap<>();
  }

  public Optional<User> getUserByName(String username) {
    return Optional.ofNullable(this.usersByName.get(username));
  }

  public void registerUser(User user) {
    if (usersByName.containsKey(user.getName())) {
      return;
    }

    this.usersByName.put(user.getName(), user);
  }
}
