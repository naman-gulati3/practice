package com.practice.dsa.binary_tree;

public class GoodNodesInTree {

  public static int goodNodes(TreeNode root) {
    return countGoodNodes(root, Integer.MIN_VALUE);
  }

  private static int countGoodNodes(TreeNode node, int maxSoFar) {
    if (node == null) {
      return 0;
    }

    int count = 0;
    if (node.val >= maxSoFar) {
      count = 1;
    }

    maxSoFar = Math.max(maxSoFar, node.val);

    count += countGoodNodes(node.left, maxSoFar);
    count += countGoodNodes(node.right, maxSoFar);

    return count;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(1);
    root.left.left = new TreeNode(3);

    root.right = new TreeNode(1);
    root.right.left = new TreeNode(1);
    root.right.right = new TreeNode(5);

    System.out.println(goodNodes(root));
  }
}
