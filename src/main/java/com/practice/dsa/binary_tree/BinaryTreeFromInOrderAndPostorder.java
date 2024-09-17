package com.practice.dsa.binary_tree;

import static com.practice.dsa.binary_tree.InorderTraversal.inorderTraversal;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFromInOrderAndPostorder {

  public static TreeNode buildTree(int[] inorder, int[] postorder) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }

    TreeNode root = buildTree(0, inorder.length - 1, postorder, 0, postorder.length - 1, map);

    return root;
  }

  private static TreeNode buildTree(
      int inorderStart,
      int inorderEnd,
      int[] postorder,
      int postorderStart,
      int postorderEnd,
      Map<Integer, Integer> inorderMap) {
    if (inorderStart > inorderEnd || postorderStart > postorderEnd) {
      return null;
    }

    TreeNode root = new TreeNode(postorder[postorderEnd]);
    int inorderRoot = inorderMap.get(root.val);
    int numsLeft = inorderRoot - inorderStart;

    root.left =
        buildTree(
            inorderStart,
            inorderRoot - 1,
            postorder,
            postorderStart,
            postorderStart + numsLeft - 1,
            inorderMap);
    root.right =
        buildTree(
            inorderRoot + 1,
            inorderEnd,
            postorder,
            postorderStart + numsLeft,
            postorderEnd - 1,
            inorderMap);

    return root;
  }

  public static void main(String[] args) {
    TreeNode root = buildTree(new int[] {9, 3, 15, 20, 7}, new int[] {9, 15, 7, 20, 3});
    System.out.println(inorderTraversal(root));
  }
}
