package com.practice.lld.linkedin;

import java.util.List;

public interface LinkedInService {

  void registerUser(User user);

  User loginUser(String email, String password);

  List<User> searchUsers(String keyword);

  List<JobPosting> searchJobPostings(String keyword);

  void postJobListing(JobPosting jobPosting);

  void sendConnectionRequest(User user1, User user2);

  void acceptConnectionRequest(User user, User connectionUser);

  void sendMessage(User sender, User receiver, Message message);
}
