package com.practice.dsa.binary_search_tree;

import com.practice.dsa.binary_tree.TreeNode;
import java.util.Stack;

public class BSTIterator {

  private final Stack<TreeNode> stack;

  public BSTIterator(TreeNode root) {
    this.stack = new Stack<>();
    pushAll(root);
  }

  private void pushAll(TreeNode root) {
    while (root != null) {
      stack.push(root);

      root = root.left;
    }
  }

  public int next() {
    TreeNode tmp = stack.pop();
    pushAll(tmp.right);
    return tmp.val;
  }

  public boolean hasNext() {
    return !stack.isEmpty();
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(7);
    root.left = new TreeNode(3);
    root.right = new TreeNode(15);
    root.right.left = new TreeNode(9);
    root.right.right = new TreeNode(20);

    var bSTIterator = new BSTIterator(root);
    System.out.println(bSTIterator.next()); // return 3
    System.out.println(bSTIterator.next()); // return 7
    System.out.println(bSTIterator.hasNext()); // return True
    System.out.println(bSTIterator.next()); // return 9
    System.out.println(bSTIterator.hasNext()); // return True
    System.out.println(bSTIterator.next()); // return 15
    System.out.println(bSTIterator.hasNext()); // return True
    System.out.println(bSTIterator.next()); // return 20
    System.out.println(bSTIterator.hasNext()); // return False
  }
}
