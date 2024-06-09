package com.practice.lld.pub_sub;

import java.time.Instant;

public class Message<K, V> {
  private final K key;
  private final V value;
  private long offset = 0;
  private long epoch;

  public Message(K key, V value) {
    this.key = key;
    this.value = value;
    this.offset++;
    this.epoch = System.currentTimeMillis();
  }

  public K getKey() {
    return key;
  }

  public V getValue() {
    return value;
  }

  public long getOffset() {
    return offset;
  }

  public void setOffset(long offset) {
    this.offset = offset;
  }

  public long getEpoch() {
    return epoch;
  }

  public void setEpoch(long epoch) {
    this.epoch = epoch;
  }

  @Override
  public String toString() {
    return "Message{" +
        "key=" + key +
        ", value=" + value +
        ", offset=" + offset +
        ", epoch=" + epoch +
        '}';
  }
}
