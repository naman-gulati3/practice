package com.practice.lld.stack_overflow;

import java.time.Instant;

public class Answer {
  private int id;
  private int author;
  private String body;
  private Instant createdAt;
  private int upvotes;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getAuthor() {
    return author;
  }

  public void setAuthor(int author) {
    this.author = author;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }

  public int getUpvotes() {
    return upvotes;
  }

  public void setUpvotes(int upvotes) {
    this.upvotes = upvotes;
  }
}
