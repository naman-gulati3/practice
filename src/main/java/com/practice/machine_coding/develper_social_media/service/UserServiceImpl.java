package com.practice.machine_coding.develper_social_media.service;

import com.practice.machine_coding.develper_social_media.dto.Topic;
import com.practice.machine_coding.develper_social_media.dto.User;
import com.practice.machine_coding.develper_social_media.repository.UserRepository;
import java.util.Optional;

public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public boolean signUp(User user) {
    this.userRepository.registerUser(user);
    return true;
  }

  @Override
  public Optional<User> getUserByName(String name) {
    return this.userRepository.getUserByName(name);
  }

  @Override
  public boolean login(User user) {
    Optional<User> userFromStore = this.userRepository.getUserByName(user.getName());
    if (userFromStore.isEmpty()) {
      throw new IllegalArgumentException(
          "User with name: %s does not exist".formatted(user.getName()));
    }

    userFromStore.get().loginUser();

    return userFromStore.get().isLoggedIn();
  }

  @Override
  public boolean logOut(User user) {
    Optional<User> userFromStore = this.userRepository.getUserByName(user.getName());
    if (userFromStore.isEmpty()) {
      throw new IllegalArgumentException(
          "User with name: %s does not exist".formatted(user.getName()));
    }

    userFromStore.get().logOutUser();

    return userFromStore.get().isLoggedOut();
  }

  @Override
  public void subscribeTopic(User user, Topic topic) {
    user.getSubscribedTopics().add(topic);
  }
}
