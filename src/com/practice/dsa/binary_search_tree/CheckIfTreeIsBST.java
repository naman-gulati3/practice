package com.practice.dsa.binary_search_tree;

import com.practice.dsa.binary_tree.TreeNode;

public class CheckIfTreeIsBST {

  public static boolean isValidBST(TreeNode root) {
    return isValidBST(root, Long.MAX_VALUE, Long.MIN_VALUE);
  }

  private static boolean isValidBST(TreeNode root, long min, long max) {
    if (root == null) {
      return true;
    }

    if (root.val >= max || root.val <= min) {
      return false;
    }

    return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(1);
    root.right = new TreeNode(4);
    root.right.left = new TreeNode(3);
    root.right.right = new TreeNode(6);

    System.out.println(isValidBST(root));
  }
}
