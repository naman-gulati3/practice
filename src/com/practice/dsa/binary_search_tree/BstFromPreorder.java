package com.practice.dsa.binary_search_tree;

import static com.practice.dsa.binary_tree.PreorderTraversal.preorderTraversal;

import com.practice.dsa.binary_tree.TreeNode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BstFromPreorder {

  public static TreeNode bstFromPreorder(int[] preorder) {
    if (preorder.length == 0) {
      return null;
    }
    int[] inorder = preorder.clone();
    Arrays.sort(inorder);

    Map<Integer, Integer> inorderMap = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      inorderMap.put(inorder[i], i);
    }

    TreeNode root = buildTree(preorder, 0, preorder.length - 1, 0, inorder.length - 1, inorderMap);

    return root;
  }

  private static TreeNode buildTree(int[] preorder, int preStart, int preEnd, int inorderStart,
      int inorderEnd, Map<Integer, Integer> inorderMap) {
    if (preStart > preEnd || inorderStart > inorderEnd) {
      return null;
    }

    TreeNode root = new TreeNode(preorder[preStart]);
    int inorderRoot = inorderMap.get(root.val);
    int numsLeft = inorderRoot - inorderStart;

    root.left = buildTree(preorder, preStart + 1, preStart + numsLeft,
        inorderStart, inorderRoot - 1, inorderMap);
    root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorderRoot + 1, inorderEnd,
        inorderMap);

    return root;
  }

  public static void main(String[] args) {
    //                                        1, 5, 7, 8, 10, 12
    TreeNode root = bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12});
    System.out.println(preorderTraversal(root));
  }
}
