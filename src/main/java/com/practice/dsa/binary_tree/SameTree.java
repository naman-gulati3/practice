package com.practice.dsa.binary_tree;

public class SameTree {

  public static boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null || q == null) {
      return p == q; // check if both are null to qualify as same tree
    }

    // pre-order traversal
    return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }

  public static void main(String[] args) {
    TreeNode root1 = new TreeNode(1);
    root1.left = new TreeNode(2);

    TreeNode root2 = new TreeNode(1);
    root2.left = new TreeNode(2);

    System.out.println(isSameTree(root1, root2));
  }
}
