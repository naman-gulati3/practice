package com.practice.dsa.binary_tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaxWidth {

  record Pair(TreeNode node, int index) {

  }

  public static int widthOfBinaryTree(TreeNode root) {
    if (root == null) {
      return 0;
    }

    Queue<Pair> queue = new ArrayDeque<>();
    queue.add(new Pair(root, 0));

    int width = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      int min = queue.peek().index;

      int first = 0;
      int last = 0;

      for (int i = 0; i < size; i++) {
        Pair pair = queue.poll();
        int curIdx = pair.index - min;
        TreeNode node = pair.node;
        if (i == 0) {
          first = curIdx;
        }

        if (i == size - 1) {
          last = curIdx;
        }

        if (node.left != null) {
          queue.offer(new Pair(node.left, curIdx * 2 + 1));
        }

        if (node.right != null) {
          queue.offer(new Pair(node.right, curIdx * 2 + 2));
        }

        width = Math.max(width, last - first + 1);
      }
    }
    return width;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(3);
    root.right = new TreeNode(2);

    root.left.left = new TreeNode(5);
    root.left.right = new TreeNode(3);

    root.right.right = new TreeNode(9);

    System.out.println(widthOfBinaryTree(root));
  }
}
