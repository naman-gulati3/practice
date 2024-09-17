package com.practice.miscellaneous;

public class CustomMap<K, V> {

  int capacity;
  private Entry[] entries;

  static class Entry<K, V> {

    K key;
    V val;

    Entry<K, V> next;

    public Entry(K key, V val) {
      this.key = key;
      this.val = val;
      this.next = null;
    }
  }

  public CustomMap(int capacity) {
    this.capacity = capacity;
    this.entries = new Entry[capacity];
  }

  public void put(K key, V val) {
    int hashCode = getHash(key);
    Entry entry = entries[hashCode];

    if (entry == null) {
      entries[hashCode] = new Entry<>(key, val);
    } else {
      while (entry != null) {
        if (entry.key == key) {
          entry.val = val;
          return;
        }

        entry = entry.next;
      }

      entry.next = new Entry<>(key, val);
    }
  }

  public V get(K key) {
    int keyHash = getHash(key);
    Entry<K, V> entry = this.entries[keyHash];

    while (entry != null) {
      if (entry.key == key) {
        return entry.val;
      }
      entry = entry.next;
    }
    return null;
  }

  public V remove(K key) {
    int keyHash = getHash(key);
    Entry<K, V> entry = this.entries[keyHash];

    if (entry == null) {
      return null;
    }

    Entry<K, V> prev = null;
    Entry<K, V> curr = entry;

    while (curr != null) {
      if (curr.key == key) {
        V value = curr.val;

        if (prev == null) {
          this.entries[keyHash] = curr.next;
        } else {
          prev.next = curr.next;
        }
        return value;
      }
      prev = curr;
      curr = curr.next;
    }

    return null;
  }

  private int getHash(K key) {
    return Math.abs(key.hashCode() % capacity);
  }

  public static void main(String[] args) {
    CustomMap<String, String> map = new CustomMap<>(12);
    map.put("name", "Naman");
    map.put("age", "27");
    map.put("tendency", "suicidal");

    System.out.println(map.get("name"));
    System.out.println(map.get("age"));
    map.put("age", "28");
    System.out.println(map.get("age"));
    map.remove("age");
    System.out.println(map.get("age"));
  }
}
