package com.practice.dsa.binary_tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class InorderPreorderPostorderInSingleTraversal {

  static class Pair {

    TreeNode node;
    int count;

    public Pair(TreeNode node, int count) {
      this.node = node;
      this.count = count;
    }

    public TreeNode getNode() {
      return node;
    }

    public void setNode(TreeNode node) {
      this.node = node;
    }

    public int getCount() {
      return count;
    }

    public void setCount(int count) {
      this.count = count;
    }

    @Override
    public String toString() {
      return "Pair{" +
          "node=" + node +
          ", count=" + count +
          '}';
    }
  }

  public static List<List<Integer>> getTreeTraversal(TreeNode root) {
    List<Integer> inorder = new ArrayList<>();
    List<Integer> preorder = new ArrayList<>();
    List<Integer> postorder = new ArrayList<>();

    Stack<Pair> stack = new Stack<>();
    if (root == null) {
      return Collections.emptyList();
    }
    stack.push(new Pair(root, 1));

    while (!stack.isEmpty()) {
      Pair pair = stack.pop();

      if (pair.count == 1) {
        preorder.add(pair.node.val);
        pair.count++;
        stack.push(pair);

        if (pair.node.left != null) {
          stack.push(new Pair(pair.node.left, 1));
        }
      } else if (pair.count == 2) {
        inorder.add(pair.node.val);
        pair.count++;
        stack.push(pair);

        if (pair.node.right != null) {
          stack.push(new Pair(pair.node.right, 1));
        }
      } else {
        postorder.add(pair.node.val);
        pair.count++;
      }
    }
    return List.of(inorder, preorder, preorder);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(3);
    root.right = new TreeNode(4);

    root.left.left = new TreeNode(5);
    root.left.right = new TreeNode(2);

    root.right.left = new TreeNode(7);
    root.right.right = new TreeNode(6);

    System.out.println(getTreeTraversal(root));
  }
}
