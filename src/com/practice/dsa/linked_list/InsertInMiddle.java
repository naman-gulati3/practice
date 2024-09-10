package com.practice.dsa.linked_list;

public class InsertInMiddle {

  static class Node {

    int data;
    Node next;

    public Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  public static Node insertInMiddle(Node head, int x) {
    if (head == null) {
      return new Node(x);
    }
    Node fast = head;
    Node slow = head;

    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    Node node = new Node(x);
    Node next = slow.next;
    slow.next = node;
    node.next = next;

    return head;
  }

  public static void main(String[] args) {
    Node head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(4);

    Node newHead = insertInMiddle(head, 3);

    while (newHead != null) {
      System.out.println(newHead.data);
      newHead = newHead.next;
    }
  }
}
