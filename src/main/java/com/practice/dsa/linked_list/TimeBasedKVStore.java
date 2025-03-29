package com.practice.dsa.linked_list;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeBasedKVStore {

  static class TimeMap {

    static class ListNode {

      String val;
      int ts;

      ListNode next;

      public ListNode() {}

      public ListNode(String val, int ts) {
        this.val = val;
        this.ts = ts;
      }
    }

    private final Map<String, ListNode> map;

    public TimeMap() {
      this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
      ListNode node = map.get(key);
      if (node == null) {
        node = new ListNode(value, timestamp);
        map.put(key, node);
      } else {
        ListNode prev = null;
        while (node != null) {
          if (node.ts == timestamp) {
            node.val = value;
            return;
          } else if (node.ts > timestamp) {
            ListNode newNode = new ListNode(value, timestamp);
            if (prev != null) {
              prev.next = newNode;
              newNode.next = node;
            } else {
              // if we are at the head
              map.put(key, newNode);
            }
            return;
          }

          prev = node;
          node = node.next;
        }
        // we didn't hit any "return" statement which means we are at the end of linked list
        // insert the node at the end of the linked list
        prev.next = new ListNode(value, timestamp);
      }
    }

    public String get(String key, int timestamp) {
      ListNode node = map.get(key);
      String ans = "";

      if (node == null) {
        return ans;
      }

      while (node != null) {
        if (node.ts <= timestamp) {
          ans = node.val;
        } else {
          break;
        }
        node = node.next;
      }
      return ans;
    }
  }

  static class TimeMap2 {

    record Pair(int ts, String val) {}

    private final Map<String, List<Pair>> map;

    public TimeMap2() {
      this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
      List<Pair> node = map.get(key);
      if (node == null) {
        node = new ArrayList<>();
      }
      node.add(new Pair(timestamp, value));
      map.put(key, node);
    }

    public String get(String key, int timestamp) {
      List<Pair> values = map.get(key);
      String ans = "";
      if (values == null || values.isEmpty()) {
        return ans;
      }

      values.sort(Comparator.comparingInt(i -> i.ts));
      int low = 0;
      int high = values.size() - 1;

      while (low <= high) {
        int mid = (low + high) / 2;

        int ts = values.get(mid).ts;
        if (timestamp == ts) {
          return values.get(mid).val;
        } else if (timestamp > ts) {
          ans = values.get(mid).val;
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      }

      return ans;
    }
  }

  public static void main(String[] args) {
    var store = new TimeMap2();
    store.set("check", "one", 5);
    store.set("check", "two", 10);
    System.out.println(store.get("check", 7));
    System.out.println(store.get("check", 10));

    System.out.println(store.get("nonexistent", 7));
  }
}
