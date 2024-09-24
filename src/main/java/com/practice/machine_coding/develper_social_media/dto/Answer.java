package com.practice.machine_coding.develper_social_media.dto;

import java.time.Instant;
import java.util.concurrent.atomic.AtomicInteger;

public record Answer(Question question, User posedBy, Instant publishedAt) implements Votable {

  private static AtomicInteger upvotes;

  public Answer(Question question, User posedBy, Instant publishedAt) {
    this.question = question;
    this.posedBy = posedBy;
    this.publishedAt = publishedAt;
    upvotes = new AtomicInteger(0);
  }

  public int getUpvotes() {
    return upvotes.get();
  }

  @Override
  public int upvote() {
    return upvotes.incrementAndGet();
  }

  @Override
  public int downVote() {
    return upvotes.decrementAndGet();
  }
}
