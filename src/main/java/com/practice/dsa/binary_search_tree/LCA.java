package com.practice.dsa.binary_search_tree;

import com.practice.dsa.binary_tree.TreeNode;

public class LCA {

  public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return null;
    }
    int cur = root.val;
    if (cur < p.val && cur < q.val) {
      return lowestCommonAncestor(root.right, p, q);
    }

    if (cur > p.val && cur > q.val) {
      return lowestCommonAncestor(root.left, p, q);
    }
    return root;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(6);
    TreeNode p = new TreeNode(2);
    root.left = p;
    p.left = new TreeNode(0);
    p.right = new TreeNode(4);
    p.right.left = new TreeNode(3);
    p.right.right = new TreeNode(5);

    TreeNode q = new TreeNode(8);
    root.right = q;
    q.left = new TreeNode(7);
    q.right = new TreeNode(9);

    System.out.println(lowestCommonAncestor(root, p, q).val);
  }
}
