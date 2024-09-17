package com.practice.dsa.binary_search_tree;

public class PopulateNextRightPointer {

  static class Node {

    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
      val = _val;
      left = _left;
      right = _right;
      next = _next;
    }
  }
  ;

  public static Node connect(Node root) {
    if (root == null) {
      return null;
    }

    Node node = root;

    while (node != null) {
      Node curr = node;
      while (curr != null) {
        if (curr.left != null) {
          curr.left.next = curr.right;
        }

        if (curr.right != null && curr.next != null) {
          curr.right.next = curr.next.left;
        }
        curr = curr.next;
      }

      node = node.left;
    }
    return root;
  }

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);

    root.left.left = new Node(4);
    root.left.right = new Node(5);

    root.right.left = new Node(6);
    root.right.right = new Node(7);

    //      1
    //    /   \
    //   2     3
    //  / \   /  \
    // 4   5  6   7

    System.out.println(connect(root).val);
  }
}
