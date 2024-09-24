package com.practice.dsa.binary_tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class AllNodeAtDistanceK {

  public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    Map<TreeNode, TreeNode> parents = new HashMap<>();
    mapParents(parents, root, null);
    Map<TreeNode, Boolean> visited = new HashMap<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(target);
    visited.put(target, true);

    int currentLevel = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();

      if (currentLevel == k) {
        break;
      }
      currentLevel++;
      for (int i = 0; i < size; i++) {
        TreeNode current = queue.poll();

        if (current.left != null && !visited.containsKey(current.left)) {
          queue.offer(current.left);
          visited.put(current.left, true);
        }

        if (current.right != null && !visited.containsKey(current.right)) {
          queue.offer(current.right);
          visited.put(current.right, true);
        }

        if (parents.containsKey(current) && !visited.containsKey(parents.get(current))) {
          queue.offer(parents.get(current));
          visited.put(parents.get(current), true);
        }
      }
    }

    List<Integer> result = new ArrayList<>();
    while (!queue.isEmpty()) {
      result.add(queue.poll().val);
    }
    return result;
  }

  private static void mapParents(Map<TreeNode, TreeNode> parents, TreeNode child, TreeNode parent) {
    if (child == null) {
      return;
    }

    if (parent != null) {
      parents.put(child, parent);
    }

    mapParents(parents, child.left, child);
    mapParents(parents, child.right, child);
  }

  public static void main(String[] args) {
    TreeNode head = new TreeNode(3);
    TreeNode left = new TreeNode(5);
    head.left = left;
    head.left.left = new TreeNode(6);
    head.left.right = new TreeNode(2);
    head.left.right.right = new TreeNode(4);
    head.left.right.left = new TreeNode(7);

    head.right = new TreeNode(1);
    head.right.left = new TreeNode(0);
    head.right.right = new TreeNode(8);

    System.out.println(distanceK(head, left, 2));
  }
}
