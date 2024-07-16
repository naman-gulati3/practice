package com.practice.dsa.stack_and_queue;

import java.util.HashMap;
import java.util.Map;

class LFUCache {

  private final Map<Integer, Node> map;

  private final Map<Integer, DoublyLinkedList> freqMap;
  private Node head;
  private Node tail;
  private final int capacity;

  private int minFreq;

  static class Node {

    private final int key;
    private int value;

    private int freq;
    private Node next;
    private Node previous;

    public Node(int key, int value) {
      this.key = key;
      this.value = value;
      this.freq = 1;
    }
  }

  static class DoublyLinkedList {

    Node head;
    Node tail;

    public DoublyLinkedList() {
      this.head = new Node(-1, -1);
      this.tail = new Node(-1, -1);
      head.next = tail;
      tail.previous = head;
    }

    void addNode(Node node) {
      node.next = head.next;
      node.previous = head;
      head.next = node;
      head.next.previous = node;
    }

    public void removeNode(Node node) {
      node.next.previous = node.previous;
      node.previous.next = node.next;
    }

    // remove from tail
    public Node removeTail() {
      Node node = tail.previous;
      if (node == head) {
        return null;
      }
      removeNode(node);
      return node;
    }

    boolean isEmpty() {
      return head.next == tail;
    }
  }

  public LFUCache(int capacity) {
    this.map = new HashMap<>();
    this.freqMap = new HashMap<>();
    this.capacity = capacity;
    this.minFreq = 1;
  }

  public int get(int key) {
    Node node = map.get(key);
    if (node == null) {
      return -1;
    }
    freqMap.get(node.freq).removeNode(node);
    if (freqMap.get(node.freq).isEmpty()) {
      freqMap.remove(node.freq);
      if (minFreq == node.freq) {
        minFreq++;
      }
    }
    node.freq++;
    freqMap.computeIfAbsent(node.freq, k -> new DoublyLinkedList()).addNode(node);
    return node.value;
  }

  public void put(int key, int value) {
    if (capacity == 0) {
      return;
    }
    Node node = map.get(key);
    if (node != null) {
      node.value = value;
      get(key); // this will update the node's position
    } else {
      if (map.size() == capacity) {
        Node toRemove = freqMap.get(minFreq).removeTail();
        if (toRemove != null) {
          map.remove(toRemove.key);
        }
      }
      Node newNode = new Node(key, value);
      map.put(key, newNode);
      freqMap.computeIfAbsent(1, k -> new DoublyLinkedList()).addNode(newNode);
      minFreq = 1;
    }
  }
}

