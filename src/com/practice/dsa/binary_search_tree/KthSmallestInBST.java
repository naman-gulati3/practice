package com.practice.dsa.binary_search_tree;

import com.practice.dsa.binary_tree.TreeNode;

public class KthSmallestInBST {

  public static int kthSmallest(TreeNode root, int k) {
    int[] count = new int[1];
    int[] kthSmallest = new int[1];
    inorder(root, k, count, kthSmallest);
    return kthSmallest[0];
  }

  public static int kthLargest(TreeNode root, int k) {
    int[] count = new int[1];
    int[] kthLargest = new int[1];
    reverseInorder(root, k, count, kthLargest);
    return kthLargest[0];
  }

  private static void reverseInorder(TreeNode root, int k, int[] count, int[] kthLargest) {
    if (root == null || count[0] >= k) {
      return;
    }

    reverseInorder(root.right, k, count, kthLargest);
    count[0]++;
    if (count[0] == k) {
      kthLargest[0] = root.val;
      return;
    }
    reverseInorder(root.left, k, count, kthLargest);
  }

  private static void inorder(TreeNode root, int k, int[] count, int[] kthSmallest) {
    if (root == null || count[0] >= k) {
      return;
    }

    inorder(root.left, k, count, kthSmallest);

    count[0]++;

    if (count[0] == k) {
      kthSmallest[0] = root.val;
      return;
    }
    inorder(root.right, k, count, kthSmallest);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(3);
    root.left.left = new TreeNode(2);
    root.left.left.left = new TreeNode(1);

    root.right = new TreeNode(6);
    root.left.right = new TreeNode(4);

    System.out.println(kthSmallest(root, 3));
    System.out.println(kthLargest(root, 2));
  }
}
