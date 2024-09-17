package com.practice.dsa.binary_search_tree;

import com.practice.dsa.binary_tree.TreeNode;

public class MaxSumSubtree {

  static int maxSum = 0;

  static class NodeValue {

    int min;
    int max;
    int size;
    int sum;

    public NodeValue(int min, int max, int size, int sum) {
      this.min = min;
      this.max = max;
      this.size = size;
      this.sum = sum;
    }
  }

  public static int maxSumBST(TreeNode root) {
    helper(root);
    return maxSum;
  }

  private static NodeValue helper(TreeNode root) {
    if (root == null) {
      return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, 0);
    }

    // postorder
    NodeValue left = helper(root.left);
    NodeValue right = helper(root.right);

    if (left.max < root.val && root.val < right.min) {
      // valid BST
      int currentSum = left.sum + right.sum + root.val;
      maxSum = Math.max(maxSum, currentSum);

      return new NodeValue(
          Math.min(root.val, left.min),
          Math.max(root.val, right.max),
          left.size + right.size + 1,
          currentSum);
    }

    // invalid BST
    return new NodeValue(
        Integer.MIN_VALUE,
        Integer.MAX_VALUE,
        Math.max(left.size, right.size),
        Math.max(left.sum, right.sum));
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(4);
    root.left.left = new TreeNode(2);
    root.left.right = new TreeNode(4);

    root.right = new TreeNode(3);
    root.right.left = new TreeNode(2);
    root.right.right = new TreeNode(5);
    root.right.right.left = new TreeNode(4);
    root.right.right.right = new TreeNode(6);

    //             1
    //           /   \
    //          4     3
    //        /  \   /  \
    //       2    4  2   5
    //                 /   \
    //                4     6

    System.out.println(maxSumBST(root));
  }
}
