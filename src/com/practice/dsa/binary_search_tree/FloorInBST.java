package com.practice.dsa.binary_search_tree;

public class FloorInBST {

  static class TreeNode<T> {

    T data;
    TreeNode<T> left;
    TreeNode<T> right;

    TreeNode(T data) {
      this.data = data;
      left = null;
      right = null;
    }
  }

  public static int floorInBST(TreeNode<Integer> root, int X) {
    int floor = -1;
    if (root == null) {
      return floor;
    }

    while (root != null) {
      if (root.data == X) {
        return X;
      } else if (X > root.data) {
        floor = root.data;
        root = root.right;
      } else {
        root = root.left;
      }
    }
    return floor;
  }

  public static void main(String[] args) {
    TreeNode<Integer> root = new TreeNode<>(10);
    root.left = new TreeNode<>(5);
    root.left.left = new TreeNode<>(2);
    root.left.right = new TreeNode<>(6);

    root.right = new TreeNode<>(15);

    //           10
    //         /   \
    //        5     15
    //      /   \
    //     2     6

    System.out.println(floorInBST(root, 7));
  }
}
