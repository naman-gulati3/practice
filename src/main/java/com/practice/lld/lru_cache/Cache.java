package com.practice.lld.lru_cache;

import java.util.HashMap;
import java.util.Map;

public class Cache<K, V> {
  private final int initialCapacity;
  private Node<K, V> head;

  private Node<K, V> tail;

  private final Map<K, Node<K, V>> map;

  public Cache(int initialCapacity) {
    this.initialCapacity = initialCapacity;
    this.map = new HashMap<>(initialCapacity);
    this.head = new Node<>(null, null);
    this.tail = new Node<>(null, null);
    this.head.next = tail;
    this.tail.prev = head;
  }

  public synchronized void set(K key, V value) {
    Node<K, V> node = this.map.get(key);
    if (node != null) {
      node.val = value;
      moveToHead(node);
    } else {
      node = new Node<>(key, value);
      map.put(key, node);
      addToHead(node);

      if (this.map.size() > initialCapacity) {
        Node<K, V> removed = removeTail();
        map.remove(removed.key);
      }
    }
  }

  public synchronized V get(K key) {
    Node<K, V> node = map.get(key);
    if (node == null) {
      return null;
    } else {
      moveToHead(node);
      return node.val;
    }
  }

  private Node<K, V> removeTail() {
    Node<K, V> node = tail.prev;
    removeNode(node);
    return node;
  }

  private void removeNode(Node<K, V> node) {
    node.next.prev = node.prev;
    node.prev.next = node.next;
  }

  private void addToHead(Node<K, V> node) {
    node.next = head.next;
    head.next.prev = node;
    node.prev = head;
    head.next = node;
  }

  private void moveToHead(Node<K, V> node) {
    removeNode(node);
    addToHead(node);
  }
}
