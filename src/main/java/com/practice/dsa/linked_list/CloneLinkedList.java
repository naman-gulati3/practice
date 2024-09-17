package com.practice.dsa.linked_list;

import java.util.HashMap;
import java.util.Map;

public class CloneLinkedList {

  static class Node {

    int val;
    Node next;
    Node random;

    public Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }

    public static Node copyRandomList(Node head) {
      Map<Node, Node> map = new HashMap<>();
      Node tmp = head;

      while (tmp != null) {
        Node dup = new Node(tmp.val);
        map.put(tmp, dup);
        tmp = tmp.next;
      }
      tmp = head;

      while (tmp != null) {
        Node clone = map.get(tmp);
        clone.next = map.get(tmp.next);
        clone.random = map.get(tmp.random);
        tmp = tmp.next;
      }
      return map.get(head);
    }

    public static void main(String[] args) {
      Node n1 = new Node(7);
      Node n2 = new Node(13);
      n1.next = n2;
      Node n3 = new Node(11);
      n2.next = n3;
      Node n4 = new Node(10);
      n3.next = n4;
      Node n5 = new Node(1);
      n4.next = n5;

      n1.random = null;
      n2.random = n1;
      n3.random = n5;
      n4.random = n3;
      n5.random = n1;
    }
  }
}
