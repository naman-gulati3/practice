package com.practice.dsa.binary_tree;

import static com.practice.dsa.binary_tree.InorderTraversal.inorderTraversal;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFromInorderAndPreorder {

  public static TreeNode buildTree(int[] preorder, int[] inorder) {
    Map<Integer, Integer> inorderMap = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      inorderMap.put(inorder[i], i);
    }

    TreeNode root = buildTree(preorder, 0, preorder.length - 1, 0, inorder.length - 1, inorderMap);

    return root;
  }

  private static TreeNode buildTree(
      int[] preorder,
      int preStart,
      int preEnd,
      int inorderStart,
      int inorderEnd,
      Map<Integer, Integer> inorderMap) {
    if (preStart > preEnd || inorderStart > inorderEnd) {
      return null;
    }
    TreeNode root = new TreeNode(preorder[preStart]);
    int inorderRoot = inorderMap.get(root.val);
    int numsToLeftOfRoot = inorderRoot - inorderStart;

    root.left =
        buildTree(
            preorder,
            preStart + 1,
            preStart + numsToLeftOfRoot,
            inorderStart,
            inorderRoot - 1,
            inorderMap);

    root.right =
        buildTree(
            preorder,
            preStart + numsToLeftOfRoot + 1,
            preEnd,
            inorderRoot + 1,
            inorderEnd,
            inorderMap);

    return root;
  }

  public static void main(String[] args) {
    int[] inorder = new int[] {9, 3, 15, 20, 7};
    int[] preorder = new int[] {3, 9, 20, 15, 7};

    TreeNode root = buildTree(preorder, inorder);

    System.out.println(inorderTraversal(root));
  }
}
