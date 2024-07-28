package com.practice.dsa.binary_search_tree;

import com.practice.dsa.binary_search_tree.FloorInBST.TreeNode;

public class CeilingInBST {

  public static int findCeil(TreeNode<Integer> node, int x) {
    int ceil = -1;

    if (node == null) {
      return ceil;
    }

    while (node != null) {
      if (node.data == x) {
        return x;
      } else if (x < node.data) {
        ceil = node.data;
        node = node.left;
      } else {
        node = node.right;
      }
    }
    return ceil;
  }

  public static void main(String[] args) {
    TreeNode<Integer> root = new TreeNode<>(10);
    root.left = new TreeNode<>(5);
    root.left.left = new TreeNode<>(2);
    root.left.right = new TreeNode<>(6);

    root.right = new TreeNode<>(15);

    System.out.println(findCeil(root, 3));
  }
}
