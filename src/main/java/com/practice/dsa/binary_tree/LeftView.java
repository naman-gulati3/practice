package com.practice.dsa.binary_tree;

import java.util.ArrayList;
import java.util.List;

public class LeftView {

  static ArrayList<Integer> leftView(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<>();

    traverse(root, 0, result);
    return result;
  }

  static void traverse(TreeNode root, int level, List<Integer> levels) {
    if (root != null) {
      if (level == levels.size()) {
        levels.add(root.val);
      }
      traverse(root.left, level + 1, levels);
      traverse(root.right, level + 1, levels);
    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    TreeNode l1 = new TreeNode(2);
    TreeNode r1 = new TreeNode(3);

    TreeNode l2 = new TreeNode(4);
    TreeNode r2 = new TreeNode(5);

    TreeNode l3 = new TreeNode(6);
    TreeNode r3 = new TreeNode(7);

    TreeNode r4 = new TreeNode(8);

    //                1
    //              /  \
    //             2    3
    //           / \    / \
    //          4   5  6   7
    //              \
    //               8

    root.left = l1;
    root.right = r1;

    l1.left = l2;
    l1.right = r2;

    r1.left = l3;
    r1.right = r3;

    r2.right = r4;
    //
    //    TreeNode root = new TreeNode(10);
    //    TreeNode l1 = new TreeNode(20);
    //    TreeNode r1 = new TreeNode(30);
    //    TreeNode l2 = new TreeNode(40);
    //    TreeNode r2 = new TreeNode(60);
    //
    //    root.left = l1;
    //    root.right = r1;
    //
    //    l1.left = l2;
    //    l1.right = r2;
    //
    System.out.println(leftView(root));
  }
}
