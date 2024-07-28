package com.practice.dsa.binary_tree;

public class SatisfySumProperty {

  // root = left + right
  public static void satisfySumProperty(TreeNode root) {
    if (root == null) {
      return;
    }

    int child = 0;
    if (root.left != null) {
      child += root.left.val;
    }

    if (root.right != null) {
      child += root.right.val;
    }

    // simply make root's val to the sum of left + right if (left + right) > root.val
    if (child >= root.val) {
      root.val = child;
    } else {
      if (root.left != null) {
        root.left.val = root.val;
      }

      if (root.right != null) {
        root.right.val = root.val;
      }
    }

    satisfySumProperty(root.left);
    satisfySumProperty(root.right);

    int total = 0;
    if (root.left != null) {
      total += root.left.val;
    }

    if (root.right != null) {
      total += root.right.val;
    }

    // if not a leaf node
    if (root.left != null || root.right != null) {
      root.val = total;
    }
  }

  public static boolean isSumProperty(TreeNode root) {
    if (root == null || (root.left == null && root.right == null)) {
      return true;
    }

    int count = 0;
    if (root.left != null) {
      count += root.left.val;
    }

    if (root.right != null) {
      count += root.right.val;
    }

    if (root.val == count) {
      return isSumProperty(root.left) && isSumProperty(root.right);
    }

    return false;
  }

  public static void main(String[] args) {
//    TreeNode root = new TreeNode(40);
//    root.left = new TreeNode(10);
//    root.right = new TreeNode(20);
//    root.left.left = new TreeNode(2);
//    root.left.right = new TreeNode(5);
//    root.right.left = new TreeNode(30);
//    root.right.right = new TreeNode(40);

    TreeNode root = new TreeNode(35);
    root.left = new TreeNode(20);
    root.right = new TreeNode(15);

    root.left.left = new TreeNode(15);
    root.left.right = new TreeNode(5);

    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);

//    satisfySumProperty(root);
//    System.out.println(inorderTraversal(root));
    System.out.println(isSumProperty(root));
  }
}
