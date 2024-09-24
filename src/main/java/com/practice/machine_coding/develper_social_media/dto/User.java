package com.practice.machine_coding.develper_social_media.dto;

import java.util.ArrayList;
import java.util.List;

public class User {

  private final String name;

  private final String profession;

  private final List<Topic> subscribedTopics;

  private final List<Answer> answers;

  private boolean isLoggedIn;

  public User(String name, String profession) {
    this.name = name;
    this.profession = profession;
    this.subscribedTopics = new ArrayList<>();
    this.answers = new ArrayList<>();
    this.isLoggedIn = false;
  }

  public List<Answer> getAnswers() {
    return answers;
  }

  public void postAnswer(Answer answer) {
    answers.add(answer);
  }

  public String getName() {
    return name;
  }

  public String getProfession() {
    return profession;
  }

  public List<Topic> getSubscribedTopics() {
    return subscribedTopics;
  }

  public boolean isLoggedIn() {
    return isLoggedIn;
  }

  public boolean isLoggedOut() {
    return !isLoggedIn;
  }

  public void loginUser() {
    this.isLoggedIn = true;
  }

  public void logOutUser() {
    this.isLoggedIn = false;
  }

  @Override
  public String toString() {
    return "User{" +
        "name='" + name + '\'' +
        ", profession='" + profession + '\'' +
        ", subscribedTopics=" + subscribedTopics +
        ", answers=" + answers +
        ", isLoggedIn=" + isLoggedIn +
        '}';
  }
}
