package com.practice.dsa.binary_tree;

public class Diameter {

  public static int diameterOfBinaryTree(TreeNode root) {
    int[] diameter = new int[1];
    calculateHeight(root, diameter);
    return diameter[0];
  }

  private static int calculateHeight(TreeNode node, int[] diameter) {
    if (node == null) {
      return 0;
    }
    int leftHeight = calculateHeight(node.left, diameter);
    int rightHeight = calculateHeight(node.right, diameter);

    diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);
    return 1 + Math.max(leftHeight, rightHeight);
  }

  public static void main(String[] args) {
    //            1
    //         /    \
    //        2       3
    //      /  \
    //    4    5

    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);

    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);

    System.out.println(diameterOfBinaryTree(root));
  }
}
