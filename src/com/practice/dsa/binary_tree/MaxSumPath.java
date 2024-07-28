package com.practice.dsa.binary_tree;

public class MaxSumPath {

  public static int maxPathSum(TreeNode root) {
    int[] width = new int[1];
    helper(root, width);
    return width[0];
  }

  private static int helper(TreeNode root, int[] width) {
    if (root == null) {
      return 0;
    }

    int left = helper(root.left, width);
    int right = helper(root.right, width);

    left = Math.max(0, left);
    right = Math.max(0, right);

    width[0] = Math.max(width[0], left + right + root.val);
    return Math.max(left, right) + root.val;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(-10);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);

    //           -10
    //          /    \
    //         9      20
    //               /   \
    //              15    7

    System.out.println(maxPathSum(root));
  }
}
