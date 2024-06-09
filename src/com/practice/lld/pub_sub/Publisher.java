package com.practice.lld.pub_sub;

public class Publisher<K, V> {
  private final Topic<K,V> topic;

  public Publisher(Topic<K, V> topic) {
    this.topic = topic;
  }

  public Topic<K, V> getTopic() {
    return topic;
  }

  public boolean publish(Message<K, V> message) {
    return this.topic.publish(message);
  }
}
