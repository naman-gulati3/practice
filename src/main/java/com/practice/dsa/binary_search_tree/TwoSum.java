package com.practice.dsa.binary_search_tree;

import com.practice.dsa.binary_tree.TreeNode;
import java.util.Stack;

public class TwoSum {

  static class BSTIterator {

    private final Stack<TreeNode> stack;
    boolean isReverse;

    public BSTIterator(TreeNode root, boolean isReverse) {
      this.stack = new Stack<>();
      this.isReverse = isReverse;
      pushAll(root);
    }

    private void pushAll(TreeNode root) {
      if (root == null) {
        return;
      }
      while (root != null) {
        stack.push(root);
        if (isReverse) {
          root = root.right;
        } else {
          root = root.left;
        }
      }
    }

    public boolean hasNext() {
      return !stack.isEmpty();
    }

    public int next() {
      if (!hasNext()) {
        return -1;
      }
      TreeNode tmp = stack.pop();
      if (isReverse) {
        pushAll(tmp.left);
      } else {
        pushAll(tmp.right);
      }
      return tmp.val;
    }
  }

  public static boolean findTarget(TreeNode root, int k) {
    if (root == null) {
      return false;
    }
    BSTIterator l = new BSTIterator(root, false); // next() will return next greater element
    BSTIterator r = new BSTIterator(root, true); // next() will return next smaller element

    int i = l.next();
    int j = r.next();

    while (i < j) {
      if (i + j == k) {
        return true;
      } else if (i + j < k) {
        i = l.next();
      } else {
        j = r.next();
      }
    }
    return false;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(3);
    root.left.left = new TreeNode(2);
    root.left.right = new TreeNode(4);

    root.right = new TreeNode(6);
    root.right.right = new TreeNode(7);

    System.out.println(findTarget(root, 9));
  }
}
