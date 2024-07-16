package com.practice.dsa.stack_and_queue;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

  private Map<Integer, Node> map;
  private Node head;
  private Node tail;
  private int capacity;

  class Node {

    private int key;
    private int value;
    private Node next;
    private Node previous;

    public Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.head = new Node(-1, -1);
    this.tail = new Node(-1, -1);
    this.map = new HashMap<>(capacity);
    head.next = tail;
    tail.previous = head;
  }

  public int get(int key) {
    Node node = map.get(key);
    if (node != null) {
      moveToHead(node);
      return node.value;
    }
    return -1;
  }

  public void put(int key, int value) {
    Node node = this.map.get(key);
    if (node != null) {
      node.value = value;
      moveToHead(node);
    } else {
      node = new Node(key, value);
      map.put(key, node);
      addToHead(node);
      if (map.size() > capacity) {
        Node removed = removeTail();
        map.remove(removed.key);
      }
    }
  }

  private Node removeTail() {
    Node node = tail.previous;
    removeNode(node);
    return node;
  }

  private void addToHead(Node node) {
    // head -> <- n1 -> <- n2 -> n3 <- n4 -> <- tail -> null

    node.previous = head;
    node.next = head.next;
    head.next.previous = node;
    head.next = node;
  }

  private void moveToHead(Node node) {
    removeNode(node);
    addToHead(node);
  }

  private void removeNode(Node node) {
    node.previous.next = node.next;
    node.next.previous = node.previous;
  }
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj = new
 * LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */
