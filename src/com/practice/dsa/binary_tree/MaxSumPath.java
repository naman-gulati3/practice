package com.practice.dsa.binary_tree;

public class MaxSumPath {

  public static int maxPathSum(TreeNode root) {
    int[] maxPathSum = new int[1];
    helper(root, maxPathSum);
    return maxPathSum[0];
  }

  private static int helper(TreeNode root, int[] maxPathSum) {
    if (root == null) {
      return 0;
    }

    int leftMaxHeight = helper(root.left, maxPathSum);
    int rightMaxHeight = helper(root.right, maxPathSum);

    leftMaxHeight = Math.max(0, leftMaxHeight);
    rightMaxHeight = Math.max(0, rightMaxHeight);

    maxPathSum[0] = Math.max(maxPathSum[0], leftMaxHeight + rightMaxHeight + root.val);
    return Math.max(leftMaxHeight, rightMaxHeight) + root.val;
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
