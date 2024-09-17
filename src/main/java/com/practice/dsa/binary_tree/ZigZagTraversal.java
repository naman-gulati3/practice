package com.practice.dsa.binary_tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal {

  public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }

    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);
    boolean leftToRight = true;

    while (!queue.isEmpty()) {
      int size = queue.size();
      int[] currentLevel = new int[size];

      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        int index = leftToRight ? i : (size - 1 - i);
        currentLevel[index] = node.val;

        if (node.left != null) {
          queue.offer(node.left);
        }

        if (node.right != null) {
          queue.offer(node.right);
        }
      }
      leftToRight = !leftToRight;
      result.add(Arrays.stream(currentLevel).boxed().toList());
    }
    return result;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);

    System.out.println(zigzagLevelOrder(root));
  }
}
