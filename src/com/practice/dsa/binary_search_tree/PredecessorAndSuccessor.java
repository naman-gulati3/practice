package com.practice.dsa.binary_search_tree;

import com.practice.dsa.binary_tree.TreeNode;

public class PredecessorAndSuccessor {

  public static void findPreSuc(TreeNode root, TreeNode[] pre, TreeNode[] suc, int key) {
    TreeNode curr = root;

    while (curr != null) {
      if (curr.val <= key) {
        curr = curr.right;
      } else {
        suc[0] = curr;
        curr = curr.left;
      }
    }
    curr = root;

    while (curr != null) {
      if (curr.val >= key) {
        curr = curr.left;
      } else {
        pre[0] = curr;
        curr = curr.right;
      }
    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(8);
    root.left = new TreeNode(1);
    root.left.right = new TreeNode(4);
    root.left.left = new TreeNode(3);

    root.right = new TreeNode(9);
    root.right.right = new TreeNode(10);

    TreeNode[] pre = new TreeNode[1];
    TreeNode[] succ = new TreeNode[1];
    findPreSuc(root, pre, succ, 8);

    System.out.println(pre[0].val);
    System.out.println(succ[0].val);
  }
}
