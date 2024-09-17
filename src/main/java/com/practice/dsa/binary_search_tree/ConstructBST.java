package com.practice.dsa.binary_search_tree;

import static com.practice.dsa.binary_tree.InorderTraversal.inorderTraversal;

import com.practice.dsa.binary_tree.TreeNode;

public class ConstructBST {

  public static TreeNode sortedArrayToBST(int[] nums) {
    return createBST(nums, 0, nums.length - 1);
  }

  private static TreeNode createBST(int[] nums, int l, int r) {
    if (l > r) {
      return null;
    }

    int mid = (r + l) / 2;
    TreeNode root = new TreeNode(nums[mid]);
    root.left = createBST(nums, l, mid - 1);
    root.right = createBST(nums, mid + 1, r);
    return root;
  }

  public static void main(String[] args) {
    TreeNode root = sortedArrayToBST(new int[] {-10, -3, 0, 5, 9});

    System.out.println(inorderTraversal(root));
  }
}
