package com.practice.lld.pub_sub;

import java.util.ArrayList;
import java.util.List;

public class Consumer<K, V> {
  private List<Topic<K, V>> subscribedTopics;

  public Consumer() {
    this.subscribedTopics = new ArrayList<>();
  }

  public boolean subscribe(Topic<K, V> topic) {
    return this.subscribedTopics.add(topic);
  }

  public void poll() {
    for(Topic<K, V> topic : subscribedTopics) {
      List<Message<K, V>> messages = topic.getMessages();
      for(Message<K, V> message : messages) {
        System.out.printf("Received message %s from topic: %s%n", message, topic);
      }
    }
  }
}
