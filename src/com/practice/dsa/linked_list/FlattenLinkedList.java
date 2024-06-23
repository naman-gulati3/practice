package com.practice.dsa.linked_list;

public class FlattenLinkedList {

  static class Node {

    int data;
    Node next;
    Node bottom;

    Node(int d) {
      data = d;
      next = null;
      bottom = null;
    }
  }

  private static Node flatten(Node root) {
    if (root == null || root.next == null) {
      return root;
    }

    root.next = flatten(root.next);

    root = mergeTwoLists(root, root.next);
    return root;
  }

  private static Node mergeTwoLists(Node a, Node b) {
    Node dummy = new Node(0);
    Node res = dummy;

    while (a != null && b != null) {
      if (a.data < b.data) {
        dummy.bottom = a;
        dummy = dummy.bottom;
        a = a.bottom;
      } else {
        dummy.bottom = b;
        dummy = dummy.bottom;
        b = b.bottom;
      }
    }

    if (a != null) {
      dummy.bottom = a;
    } else {
      dummy.bottom = b;
    }
    return res.bottom;
  }

  public static void main(String[] args) {
    Node n1 = new Node(5);
    Node n2 = new Node(7);
    Node n3 = new Node(8);
    Node n4 = new Node(30);
    n1.bottom = n2;
    n2.bottom = n3;
    n3.bottom = n4;
    n4.bottom = null;

    Node n5 = new Node(10);
    n1.next = n5;

    Node n6 = new Node(19);
    Node n7 = new Node(22);
    Node n8 = new Node(50);
    n5.next = n6;
    n6.bottom = n7;
    n7.bottom = n8;

    Node n9 = new Node(28);
    n6.next = n9;

    Node flattened = flatten(n1);
    while (flattened != null) {
      System.out.println(flattened.data);
      flattened = flattened.next;
    }
  }
}
