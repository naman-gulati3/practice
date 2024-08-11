package com.practice.dsa.binary_tree;

import java.util.ArrayList;
import java.util.List;

public class RootToNodePath {

  public static ArrayList<ArrayList<Integer>> getPathToLeafNodes(TreeNode root) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    traverse(result, root, new ArrayList<>());

    return result;
  }

  public static List<Integer> getPathToNode(TreeNode root, int val) {
    List<Integer> result = new ArrayList<>();

    if (root == null) {
      return result;
    }
    traverse(root, result, val);

    return result;
  }

  private static boolean traverse(TreeNode root,
      List<Integer> currentResult, int val) {
    if (root == null) {
      return false;
    }

    currentResult.add(root.val);
    if (root.val == val) {
      return true;
    }

    if (traverse(root.left, currentResult, val) || traverse(root.right, currentResult, val)) {
      return true;
    }
    currentResult.remove(currentResult.size() - 1);

    return false;
  }


  private static void traverse(ArrayList<ArrayList<Integer>> result, TreeNode root,
      ArrayList<Integer> currentRes) {
    if (root == null) {
      return;
    }

    currentRes.add(root.val);
    if (root.left == null && root.right == null) {
      result.add(new ArrayList<>(currentRes));
    } else {
      traverse(result, root.left, currentRes);
      traverse(result, root.right, currentRes);
    }
    currentRes.remove(currentRes.size() - 1);
  }


  public static void main(String[] args) {
    TreeNode root = new TreeNode(10);
    root.left = new TreeNode(20);
    root.right = new TreeNode(30);
    root.left.left = new TreeNode(40);
    root.left.right = new TreeNode(60);
    //        10
    //       /  \
    //      20   30
    //     / \
    //   40   60

//    System.out.println(Paths(root));
    System.out.println(getPathToNode(root, 40));
    System.out.println(getPathToLeafNodes(root));
  }

}
