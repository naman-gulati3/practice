package com.practice.machine_coding.flip_cache.dto;

import java.time.Instant;

public class KeyWithTime<K> extends CacheKey<K> {

  private K key;
  private Instant timestamp;

  public KeyWithTime(K value, Instant timestamp) {
    this.key = value;
    this.timestamp = timestamp;
  }

  public K getKey() {
    return key;
  }

  public void setKey(K key) {
    this.key = key;
  }

  public Instant getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Instant timestamp) {
    this.timestamp = timestamp;
  }
}
