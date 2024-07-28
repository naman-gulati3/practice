package com.practice.dsa.binary_tree;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {

  public static List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();

    traverse(result, root);
    return result;
  }

  private static void traverse(List<Integer> result, TreeNode node) {
    if (node != null) {
      result.add(node.val);
      traverse(result, node.left);
      traverse(result, node.right);
    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    TreeNode right = new TreeNode(2);
    TreeNode left = new TreeNode(3);
    root.right = right;
    right.left = left;
    System.out.println(preorderTraversal(root));
  }
}
