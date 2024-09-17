package com.practice.dsa.binary_tree;

import java.util.Stack;

public class FlattenToLinkedList {

  private static TreeNode prev = null;

  public static void flattenBetter(TreeNode root) {
    if (root == null) {
      return;
    }

    Stack<TreeNode> stack = new Stack<>();

    stack.push(root);

    while (!stack.isEmpty()) {
      TreeNode curr = stack.pop();

      if (curr.right != null) {
        stack.push(curr.right);
      }

      if (curr.left != null) {
        stack.push(curr.left);
      }

      if (!stack.isEmpty()) {
        curr.right = stack.peek();
      }
      curr.left = null;
    }
  }

  public static void flattenOptimal(TreeNode root) {
    if (root == null) {
      return;
    }

    TreeNode curr = root;
    while (curr != null) {
      if (curr.left != null) {
        TreeNode prev = curr.left;
        while (prev.right != null) {
          prev = prev.right;
        }

        prev.right = curr.right;
        curr.right = curr.left;
        curr.left = null;
      }
      curr = curr.right;
    }
  }

  public static void flattenBrute(TreeNode root) {
    if (root == null) {
      return;
    }

    flattenBrute(root.right);
    flattenBrute(root.left);

    root.right = prev;
    root.left = null;
    prev = root;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(4);
    root.right = new TreeNode(5);
    root.right.right = new TreeNode(6);
    //          1
    //        /   \
    //       2      5
    //     /  \      \
    //    3   4       6

    flattenBetter(root);
    while (root.right != null) {
      System.out.println(root.val);
      root = root.right;
    }
  }
}
