package com.practice.lld.linkedin;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {

  private String id;
  private String name;
  private String email;
  private String password;

  private Instant lastLoggedIn;
  private final Set<User> connections;

  private final List<Message> inbox;
  private final List<Message> sentMessages;

  private final Set<NotificationType> subscribedNotificationTypes;

  public User(String name, String email, String password) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.connections = new HashSet<>();
    this.inbox = new ArrayList<>();
    this.sentMessages = new ArrayList<>();
    this.subscribedNotificationTypes = new HashSet<>();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Instant getLastLoggedIn() {
    return lastLoggedIn;
  }

  public void setLastLoggedIn(Instant lastLoggedIn) {
    this.lastLoggedIn = lastLoggedIn;
  }

  public Set<User> getConnections() {
    return connections;
  }

  public void addConnections(User user) {
    this.connections.add(user);
  }

  public List<Message> getInbox() {
    return inbox;
  }

  public void receiveMessage(Message message) {
    this.inbox.add(message);
  }

  public void sentMessage(Message message) {
    this.sentMessages.add(message);
  }

  public List<Message> getSentMessages() {
    return sentMessages;
  }

  public Set<NotificationType> getSubscribedNotificationTypes() {
    return subscribedNotificationTypes;
  }

  public void addSubscribedNotificationType(NotificationType notificationType) {
    subscribedNotificationTypes.add(notificationType);
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
