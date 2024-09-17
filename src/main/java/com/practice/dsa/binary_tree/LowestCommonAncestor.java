package com.practice.dsa.binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LowestCommonAncestor {

  public static TreeNode lowestCommonAncestorOptimal(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) {
      return root;
    }

    TreeNode leftAncestor = lowestCommonAncestorOptimal(root.left, p, q);
    TreeNode rightAncestor = lowestCommonAncestorOptimal(root.right, p, q);

    if (leftAncestor == null) {
      return rightAncestor;
    } else if (rightAncestor == null) {
      return leftAncestor;
    } else {
      return root;
    }
  }

  public static TreeNode lowestCommonAncestorBetter(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return null;
    }

    List<TreeNode> pathTop = new ArrayList<>();
    List<TreeNode> pathToq = new ArrayList<>();
    traverse(root, pathTop, p.val);
    traverse(root, pathToq, q.val);

    TreeNode common = null;

    List<TreeNode> nodesToSearch;
    nodesToSearch = pathTop.size() > pathToq.size() ? pathToq : pathTop;
    for (int i = 0; i < nodesToSearch.size(); i++) {
      if (Objects.equals(pathTop.get(i).val, pathToq.get(i).val)) {
        common = pathTop.get(i);
      } else {
        break;
      }
    }

    return common;
  }

  private static boolean traverse(TreeNode root, List<TreeNode> nodes, int val) {
    if (root == null) {
      return false;
    }

    nodes.add(root);
    if (root.val == val) {
      return true;
    }

    if (traverse(root.left, nodes, val) || traverse(root.right, nodes, val)) {
      return true;
    }
    nodes.remove(nodes.size() - 1);
    return false;
  }

  public static void main(String[] args) {
    //           3
    //        /    \
    //       5      1
    //     /  \    / \
    //    6    2  0   8
    //        / \
    //       7   4
    TreeNode root = new TreeNode(3);
    TreeNode left = new TreeNode(5);
    root.left = left;
    left.left = new TreeNode(6);
    left.right = new TreeNode(2);
    left.right.left = new TreeNode(7);
    left.right.right = new TreeNode(4);

    TreeNode right = new TreeNode(1);
    root.right = right;
    right.left = new TreeNode(0);
    right.right = new TreeNode(8);

    System.out.println(lowestCommonAncestorBetter(root, left, right).val);
  }
}
