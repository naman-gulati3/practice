package com.practice.dsa.binary_tree;

public class BalancedBinaryTree {

  public static boolean isBalancedOptimal(TreeNode root) {
    if (root == null) {
      return true;
    }

    int height = checkIfBalanced(root);

    return height != -1;
  }

  private static int checkIfBalanced(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int leftHeight = checkIfBalanced(root.left);
    int rightHeight = checkIfBalanced(root.right);

    if (leftHeight == -1 || rightHeight == -1) {
      return -1;
    }

    if (Math.abs(leftHeight - rightHeight) > 1) {
      return -1;
    }

    return 1 + Math.max(leftHeight, rightHeight);
  }

  public static boolean isBalancedBrute(TreeNode root) {
    if (root == null) {
      return true;
    }
    int l = checkHeight(root.left);
    int r = checkHeight(root.right);
    if (Math.abs(l - r) > 1) {
      return false;
    }
    boolean isLeftBalanced = isBalancedBrute(root.left);
    boolean isRightBalanced = isBalancedBrute(root.right);

    return isLeftBalanced && isRightBalanced;
  }

  private static int checkHeight(TreeNode node) {
    if (node == null) {
      return 0;
    }

    int leftHeight = checkHeight(node.left);
    int rightHeight = checkHeight(node.right);

    return 1 + Math.max(leftHeight, rightHeight);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);
    System.out.println(isBalancedOptimal(root));
  }
}
