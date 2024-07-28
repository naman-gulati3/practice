package com.practice.dsa.binary_search_tree;

import com.practice.dsa.binary_tree.TreeNode;

public class SearchInBST {

  public static TreeNode searchBST(TreeNode root, int val) {
    if (root == null) {
      return null;
    }

    if (root.val == val) {
      return root;
    }

    if (val > root.val) {
      return searchBST(root.right, val);
    } else {
      return searchBST(root.left, val);
    }
  }

  public static TreeNode searchBST2(TreeNode root, int val) {
    while (root != null && root.val != val) {
      root = val > root.val ? root.right : root.left;
    }
    return root;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.right = new TreeNode(7);

    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);

    System.out.println(searchBST2(root, 2).val);
  }
}
