package com.practice.dsa.binary_tree;

import static com.practice.dsa.binary_tree.InorderTraversal.inorderTraversal;

public class Mirror {

  static void mirror(TreeNode root) {
    if (root == null) {
      return;
    }
    mirror(root.left);
    mirror(root.right);
    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(10);
    root.left = new TreeNode(20);
    root.right = new TreeNode(30);

    root.left.left = new TreeNode(40);
    root.left.right = new TreeNode(60);
    System.out.println(inorderTraversal(root));
    mirror(root);

    System.out.println(inorderTraversal(root));
  }
}
