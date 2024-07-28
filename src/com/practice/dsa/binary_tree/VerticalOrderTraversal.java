package com.practice.dsa.binary_tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrderTraversal {

  record Tuple(TreeNode node, int verticalLevel, int level) {

  }

  public static List<List<Integer>> verticalTraversal(TreeNode root) {
    // key = vertical level, val = map of level and queue of node values at that level
    Map<Integer, Map<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
    Queue<Tuple> queue = new ArrayDeque<>();

    queue.offer(new Tuple(root, 0, 0));

    while (!queue.isEmpty()) {
      Tuple tuple = queue.poll();
      TreeNode node = tuple.node;
      int verticalLevel = tuple.verticalLevel;
      int level = tuple.level;

      if (!map.containsKey(verticalLevel)) {
        map.put(verticalLevel, new TreeMap<>());
      }

      if (!map.get(verticalLevel).containsKey(level)) {
        map.get(verticalLevel).put(level, new PriorityQueue<>());
      }

      map.get(verticalLevel).get(level).add(node.val);

      if (node.left != null) {
        queue.offer(new Tuple(node.left, verticalLevel - 1, level + 1));
      }

      if (node.right != null) {
        queue.offer(new Tuple(node.right, verticalLevel + 1, level + 1));
      }
    }

    List<List<Integer>> result = new ArrayList<>();
    for (Map<Integer, PriorityQueue<Integer>> verticalLevels : map.values()) {
      result.add(new ArrayList<>());
      for (PriorityQueue<Integer> priorityQueue : verticalLevels.values()) {
        while (!priorityQueue.isEmpty()) {
          result.get(result.size() - 1).add(priorityQueue.poll());
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);

    System.out.println(verticalTraversal(root));
  }
}
