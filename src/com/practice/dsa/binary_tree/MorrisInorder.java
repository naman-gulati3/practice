package com.practice.dsa.binary_tree;

import java.util.ArrayList;
import java.util.List;

public class MorrisInorder {

  public static List<Integer> inorderTraversal(TreeNode root) {
    // threaded binary tree
    List<Integer> result = new ArrayList<>();
    TreeNode curr = root;
    while (curr != null) {
      if (curr.left == null) {
        result.add(curr.val);
        curr = curr.right;
      } else {
        TreeNode prev = curr.left;
        while (prev.right != null && prev.right != curr) {
          prev = prev.right;
        }

        if (prev.right == null) {
          prev.right = curr;
          curr = curr.left;
        } else {
          prev.right = null;
          result.add(curr.val);
          curr = curr.right;
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    TreeNode right = new TreeNode(2);
    TreeNode left = new TreeNode(3);
    root.right = right;
    right.left = left;
    System.out.println(inorderTraversal(root));
  }
}
