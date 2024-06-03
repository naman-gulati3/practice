package com.practice.lld.stack_overflow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class StackOverflowImpl implements StackOverflow {
  private static StackOverflow instance;
  private final Map<Integer, User> users;
  private final Map<Integer, Question> questions;
  private final Map<String, List<Question>> taggedQuestions;

  private StackOverflowImpl() {
    users = new ConcurrentHashMap<>();
    questions = new ConcurrentHashMap<>();
    taggedQuestions = new ConcurrentHashMap<>();
  }

  public static StackOverflow getInstance() {
    if(instance == null) {
      instance = new StackOverflowImpl();
    }
    return instance;
  }

  @Override
  public int addUser(User user) {
    users.put(user.getId(), user);
    return user.getId();
  }

  @Override
  public int postQuestion(Question question) {
    questions.put(question.getId(), question);
    for(Tag tag : question.getTags()) {
      taggedQuestions.computeIfAbsent(tag.name(), k -> new ArrayList<>()).add(question);
    }
    return question.getId();
  }

  @Override
  public int addComment(int authorId, Question question) {
    //
    return -1;
  }

  @Override
  public User loginUser(String username, char[] password) {
    for(User user : users.values()) {
      if(user.getUsername().equals(username) && Arrays.equals(user.getPassword(), password)) {
        return user;
      }
    }
    return null;
  }

  @Override
  public int addAnswer(Question question, Answer answer) {
    if(questions.keySet().stream().noneMatch(qId -> qId.equals(question.getId()))) {
      throw new IllegalArgumentException("Question with id %d does not exist".formatted(question.getId()));
    }

    question.getAnswers().add(answer);
    questions.put(question.getId(), question);
    return answer.getId();
  }

  @Override
  public int upvote(Answer answer, int vote) {
    synchronized (answer) {
      answer.setUpvotes(answer.getUpvotes() + vote);
    }
    updateUserRep(answer.getAuthor(), vote);
    return answer.getId();
  }

  private void updateUserRep(int author, int vote) {
    User user = users.get(author);
    synchronized (user) {
      user.setReputation(user.getReputation() + vote);
    }
  }

  public List<Question> searchQuestion(String searchString) {
    return this.questions.values().stream().filter(q -> q.getTitle().
            contains(searchString) || q.getBody().contains(searchString))
        .toList();
  }
}
