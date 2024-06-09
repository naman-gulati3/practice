package com.practice.lld.pub_sub;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Topic<K, V> {
  private final String name;
  private List<Message<K, V>> messages;

  public Topic(String name) {
    this.name = name;
    this.messages = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public List<Message<K, V>> getQueue() {
    return messages;
  }

  public boolean publish(Message<K, V> message) {
    return this.messages.add(message);
  }

  public List<Message<K, V>> getMessages() {
    return messages;
  }

  @Override
  public String toString() {
    return "Topic{" +
        "name='" + name + '\'' +
        ", messages=" + messages +
        '}';
  }
}
