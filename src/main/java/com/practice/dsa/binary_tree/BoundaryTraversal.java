package com.practice.dsa.binary_tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoundaryTraversal {

  public static List<Integer> boundaryTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (!isLeaf(root)) {
      result.add(root.val);
    }

    addLeftBoundary(root, result);
    addLeaves(root, result);
    addRightBoundary(root, result);

    return result;
  }

  private static void addRightBoundary(TreeNode root, List<Integer> result) {
    TreeNode cur = root.right;
    List<Integer> temp = new ArrayList<>();
    while (cur != null) {
      if (!isLeaf(cur)) {
        temp.add(cur.val);
      }

      if (cur.right != null) {
        cur = cur.right;
      } else {
        cur = cur.left;
      }
    }
    Collections.reverse(temp);
    result.addAll(temp);
  }

  private static void addLeaves(TreeNode root, List<Integer> result) {
    if (isLeaf(root)) {
      result.add(root.val);
      return;
    }
    if (root.left != null) {
      addLeaves(root.left, result);
    }

    if (root.right != null) {
      addLeaves(root.right, result);
    }
  }

  private static void addLeftBoundary(TreeNode root, List<Integer> result) {
    TreeNode cur = root.left;
    while (cur != null) {
      if (!isLeaf(cur)) {
        result.add(cur.val);
      }
      if (cur.left != null) {
        cur = cur.left;
      } else {
        cur = cur.right;
      }
    }
  }

  private static boolean isLeaf(TreeNode root) {
    return root != null && root.left == null && root.right == null;
  }

  public static void main(String[] args) {
    //              3
    //            /   \
    //           9    20
    //               /  \
    //              15   7
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);
    System.out.println(boundaryTraversal(root));
  }
}
