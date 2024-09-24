package com.practice.dsa.tri;

import com.practice.dsa.tri.LengthOfLongestCommonPrefix.Tri.TreeNode;

public class LengthOfLongestCommonPrefix {

  static class Tri {

    TreeNode root;

    public Tri() {
      this.root = new TreeNode();
    }

    static class TreeNode {

      private TreeNode[] children;
      private boolean isEndOfNumber;

      public TreeNode() {
        this.children = new TreeNode[10];
        this.isEndOfNumber = false;
      }

      public TreeNode getChild(char ch) {
        return this.children[ch - '0'];
      }

      public void setChild(TreeNode node, char num) {
        this.children[num - '0'] = node;
      }
    }

    @Override
    public String toString() {
      return "Tri{" +
          "root=" + root +
          '}';
    }
  }

  public static void main(String[] args) {
    System.out.println(longestCommonPrefix(new int[]{1, 10, 100}, new int[]{100}));
  }

  public static int longestCommonPrefix(int[] arr1, int[] arr2) {
    Tri tri = new Tri();
    for (int num : arr1) {
      insert(String.valueOf(num), tri);
    }

    for (int num : arr2) {
      insert(String.valueOf(num), tri);
    }

    int max = 0;
    for (int i = 0; i < arr1.length; i++) {
      String num1 = String.valueOf(arr1[i]);
      for (int j = 0; j < arr2.length; j++) {
        String num2 = String.valueOf(arr2[j]);
        max = Math.max(max, startsWith(tri, num1, num2));
      }
    }
    return max;
  }

  public static void insert(String num, Tri tri) {
    TreeNode curr = tri.root;
    for (char ch : num.toCharArray()) {
      TreeNode child = curr.getChild(ch);
      if (child == null) {
        child = new TreeNode();
        curr.setChild(child, ch);
      }
      curr = child;
    }
    curr.isEndOfNumber = true;
  }

  public static int startsWith(Tri tri, String str1, String str2) {
    int count = 0;
    TreeNode curr = tri.root;

    if (str1.length() > str2.length()) {
      String temp = str1;
      str1 = str2;
      str2 = temp;
    }

    char[] str1CharArr = str1.toCharArray();
    char[] str2CharArr = str2.toCharArray();

    for (int i = 0; i < str1CharArr.length; i++) {
      TreeNode child1 = curr.getChild(str1CharArr[i]);
      TreeNode child2 = curr.getChild(str2CharArr[i]);

      if (child1 == null || child2 == null || str1CharArr[i] != str2CharArr[i]) {
        return count;
      }

      count++;
      curr = child1;
    }

    return count;
  }
}
