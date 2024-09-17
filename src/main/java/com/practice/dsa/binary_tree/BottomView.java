package com.practice.dsa.binary_tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BottomView {

  record Pair(int hb, TreeNode node) {}

  public static ArrayList<Integer> bottomView(TreeNode root) {
    Queue<Pair> queue = new ArrayDeque<>();
    Map<Integer, Integer> map = new TreeMap<>();
    ArrayList<Integer> result = new ArrayList<>();

    queue.add(new Pair(0, root));

    while (!queue.isEmpty()) {
      Pair pair = queue.poll();

      int hd = pair.hb;
      TreeNode node = pair.node;

      map.put(hd, node.val);

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
    TreeNode root = new TreeNode(20);
    root.left = new TreeNode(8);
    root.left.left = new TreeNode(5);
    root.left.right = new TreeNode(3);
    root.left.right.left = new TreeNode(10);
    root.left.right.right = new TreeNode(14);

    root.right = new TreeNode(22);
    root.right.right = new TreeNode(25);

    System.out.println(bottomView(root));
  }
}
