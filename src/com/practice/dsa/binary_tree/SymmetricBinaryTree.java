package com.practice.dsa.binary_tree;

public class SymmetricBinaryTree {

  public static boolean isSymmetric(TreeNode root) {
    return root == null || helper(root.left, root.right);
  }

  private static boolean helper(TreeNode node1, TreeNode node2) {
    if (node1 == null || node2 == null) {
      return node1 == node2;
    }

    if (node1.val != node2.val) {
      return false;
    }

    return helper(node1.left, node2.right) && helper(node1.right, node2.left);
  }


  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(2);
    root.left.right = new TreeNode(3);
    root.right.left = new TreeNode(3);

    //        1
    //      /   \
    //     2     2
    //      \   /
    //      3   3
    System.out.println(isSymmetric(root));
  }
}
