package com.practice.machine_coding.develper_social_media.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Question implements Votable {

  private List<Topic> topics;
  private final List<Answer> answers;
  private final String text;
  private final User publishedBy;
  private final Instant publishedAt;
  private static AtomicInteger upvotes;

  public Question(User publishedBy, String text, Instant publishedAt, List<Topic> topics) {
    this.text = text;
    this.publishedBy = publishedBy;
    this.publishedAt = publishedAt;

    if (topics.isEmpty()) {
      throw new IllegalArgumentException("Question should be linked to at least one topic");
    }
    upvotes = new AtomicInteger(0);
    this.topics = topics;
    this.answers = new ArrayList<>();
  }

  @Override
  public int upvote() {
    return upvotes.incrementAndGet();
  }

  @Override
  public int downVote() {
    return upvotes.decrementAndGet();
  }

  public List<Topic> getTopics() {
    return topics;
  }

  public void setTopics(List<Topic> topics) {
    this.topics = topics;
  }

  public User getPublishedBy() {
    return publishedBy;
  }

  public Instant getPublishedAt() {
    return publishedAt;
  }

  public List<Answer> getAnswers() {
    return answers;
  }

  public void addAnswer(
      Answer answer) {
    this.answers.add(answer);
  }

  public String getText() {
    return text;
  }

  public static AtomicInteger getUpvotes() {
    return upvotes;
  }

  public static void setUpvotes(AtomicInteger upvotes) {
    Question.upvotes = upvotes;
  }

  @Override
  public String toString() {
    return "Question{" +
        "topics=" + topics +
        "upvotes=" + upvotes.get() +
        ", text='" + text + '\'' +
        ", publishedBy=" + publishedBy +
        ", publishedAt=" + publishedAt +
        '}';
  }
}
