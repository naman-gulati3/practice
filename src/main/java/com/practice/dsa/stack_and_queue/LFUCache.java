package com.practice.dsa.stack_and_queue;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

class LFUCache {

  private final Map<Integer, Node> map;

  private final Map<Integer, LinkedHashSet<Node>> freqMap;
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

  //  static class DoublyLinkedList {
  //
  //    Node head;
  //    Node tail;

  //    public DoublyLinkedList() {
  //      this.head = new Node(-1, -1);
  //      this.tail = new Node(-1, -1);
  //      head.next = tail;
  //      tail.previous = head;
  //    }
  //
  //    void addNode(Node node) {
  //      node.next = head.next;
  //      node.previous = head;
  //      head.next = node;
  //      head.next.previous = node;
  //    }
  //
  //    public void removeNode(Node node) {
  //      node.next.previous = node.previous;
  //      node.previous.next = node.next;
  //    }
  //
  //    // remove from tail
  //    public Node removeTail() {
  //      Node node = tail.previous;
  //      if (node == head) {
  //        return null;
  //      }
  //      removeNode(node);
  //      return node;
  //    }
  //
  //    boolean isEmpty() {
  //      return head.next == tail;
  //    }
  //  }

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
    // find node with freq and remove it from freq map
    updateFrequency(node);
    return node.value;
  }

  private void updateFrequency(Node node) {
    int freq = node.freq;
    freqMap.get(freq).remove(node);

    if (freqMap.get(freq).isEmpty()) {
      freqMap.remove(freq);
      if (freq == minFreq) {
        minFreq++;
      }
    }

    node.freq++;
    freqMap.computeIfAbsent(node.freq, k -> new LinkedHashSet<>()).add(node);
  }

  public void put(int key, int value) {
    if (capacity == 0) {
      return;
    }
    Node node = map.get(key);
    if (node != null) {
      node.value = value;
      updateFrequency(node); // this will update the node's position
    } else {
      if (map.size() >= capacity) {
        // remove LRU node if there is min frequency collision
        evict();
      }
      Node newNode = new Node(key, value);
      map.put(key, newNode);
      freqMap.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(newNode);
      minFreq = 1;
    }
  }

  private void evict() {
    LinkedHashSet<Node> minFreqNodes = freqMap.get(minFreq);
    if (minFreqNodes != null && !minFreqNodes.isEmpty()) {
      Node nodeToRemove = minFreqNodes.iterator().next(); // Get the first node
      minFreqNodes.remove(nodeToRemove); // Remove it from the frequency set
      map.remove(nodeToRemove.key); // Remove it from the cache

      // If no nodes are left at this frequency, remove the frequency entry
      if (minFreqNodes.isEmpty()) {
        freqMap.remove(minFreq);
      }
    }
  }
}
