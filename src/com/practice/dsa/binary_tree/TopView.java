package com.practice.dsa.binary_tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopView {

  record Pair(int hd, TreeNode node) {

  }

  static ArrayList<Integer> topView(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }
    ArrayList<Integer> result = new ArrayList<>();
    Queue<Pair> queue = new ArrayDeque<>();
    Map<Integer, Integer> map = new TreeMap<>();

    queue.offer(new Pair(0, root));

    while (!queue.isEmpty()) {
      Pair pair = queue.poll();

      int hd = pair.hd;
      TreeNode node = pair.node;

      if (!map.containsKey(hd)) {
        map.put(hd, node.val);
      }

      if (node.left != null) {
        queue.add(new Pair(hd - 1, node.left));
      }

      if (node.right != null) {
        queue.add(new Pair(hd + 1, node.right));
      }
    }

    for (var entry : map.entrySet()) {
      result.add(entry.getValue());
    }
    return result;
  }

  public static void main(String[] args) {
    //            1
    //         /    \
    //        2       3
    //      /  \    /   \
    //    4    5  6     7

    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(7);

    System.out.println(topView(root));
  }
}
