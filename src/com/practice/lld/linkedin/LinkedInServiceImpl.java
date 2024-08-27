package com.practice.lld.linkedin;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class LinkedInServiceImpl implements LinkedInService {

  private static LinkedInService instance;
  private List<User> users;
  private List<JobPosting> jobPostings;

  private Map<String, List<Notification>> userNotifications;

  public static synchronized LinkedInService getInstance() {
    if (instance == null) {
      instance = new LinkedInServiceImpl();
    }
    return instance;
  }

  public LinkedInServiceImpl() {
    this.users = new CopyOnWriteArrayList<>();
    this.userNotifications = new ConcurrentHashMap<>();
    this.jobPostings = new CopyOnWriteArrayList<>();
  }

  @Override
  public void registerUser(User user) {
    if (users.stream().anyMatch(u -> u.getEmail().equals(user.getEmail()))) {
      throw new IllegalArgumentException(
          "User: %s is already registered".formatted(user.getEmail()));
    }

    users.add(user);
  }

  @Override
  public User loginUser(String email, String password) {
    Optional<User> user = users.stream()
        .filter(u -> u.getEmail().equals(email) && u.getPassword().equals(password)).findFirst();

    user.ifPresent(value -> value.setLastLoggedIn(Instant.now()));

    return user.orElse(null);
  }

  @Override
  public List<User> searchUsers(String keyword) {
    List<User> filteredUsers = new ArrayList<>();

    for (User user : users) {
      if (user.getName().contains(keyword) || user.getEmail().contains(keyword)) {
        filteredUsers.add(user);
      }
    }
    return filteredUsers;
  }

  @Override
  public List<JobPosting> searchJobPostings(String keyword) {
    List<JobPosting> filteredJobs = new ArrayList<>();

    for (JobPosting job : jobPostings) {
      if (job.description().contains(keyword) || job.title().contains(keyword)) {
        filteredJobs.add(job);
      }
    }
    return filteredJobs;
  }

  @Override
  public void postJobListing(JobPosting jobPosting) {
    jobPostings.add(jobPosting);
  }

  @Override
  public void sendConnectionRequest(User sender, User receiver) {
    receiver.getConnections().add(sender);
    Notification notification = new Notification(UUID.randomUUID().toString(),
        NotificationType.CONNECTION_REQUEST, receiver,
        "New connection request from " + receiver.getName(),
        Instant.now()
    );

    userNotifications.computeIfAbsent(receiver.getId(), k -> new CopyOnWriteArrayList<>())
        .add(notification);
  }

  @Override
  public void acceptConnectionRequest(User user, User connectionUser) {
    for (User connection : user.getConnections()) {
      if (connection.equals(connectionUser)) {
        user.getConnections().add(connection);
        break;
      }
    }
  }

  @Override
  public void sendMessage(User sender, User receiver, Message message) {
    sender.getSentMessages().add(message);

    receiver.receiveMessage(message);
    Notification notification = new Notification(UUID.randomUUID().toString(),
        NotificationType.MESSAGE_RECEIVED, receiver, "Received message from " + sender.getName(),
        Instant.now());
    userNotifications.computeIfAbsent(receiver.getId(), k -> new CopyOnWriteArrayList<>())
        .add(notification);
  }
}
