package com.practice.machine_coding.develper_social_media.service;

import com.practice.machine_coding.develper_social_media.dto.Topic;
import com.practice.machine_coding.develper_social_media.dto.User;
import java.util.Optional;

public interface UserService {

  boolean signUp(User user);

  Optional<User> getUserByName(String name);

  boolean login(User user);

  boolean logOut(User user);

  void subscribeTopic(User user, Topic topic);
}
