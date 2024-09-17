package com.practice.dsa.tri;

public class Tri {

  TreeNode root;

  static class TreeNode {

    private TreeNode[] children;
    private boolean isWord;

    public TreeNode() {
      this.isWord = false;
      this.children = new TreeNode[26];
    }

    public TreeNode[] getChildren() {
      return children;
    }

    public void setChildren(TreeNode[] children) {
      this.children = children;
    }

    public boolean isWord() {
      return isWord;
    }

    public void setWord(boolean word) {
      isWord = word;
    }

    public TreeNode getChild(char ch) {
      return this.children[ch - 'a'];
    }

    public void setChild(TreeNode child, char ch) {
      this.children[ch - 'a'] = child;
    }
  }

  public Tri(TreeNode root) {
    this.root = new TreeNode();
  }

  public void insert(String word) {
    TreeNode node = root;
    for (char ch : word.toCharArray()) {
      TreeNode child = node.getChild(ch);
      if (child == null) {
        child = new TreeNode();
        node.setChild(child, ch);
      }
      node = child;
    }
    node.setWord(true);
  }

  public boolean search(String word) {
    TreeNode current = root;
    for (char ch : word.toCharArray()) {
      TreeNode child = current.getChild(ch);
      if (child == null) {
        return false;
      }

      current = child;
    }
    return current.isWord;
  }

  public boolean startsWith(String prefix) {
    TreeNode current = root;
    for (char ch : prefix.toCharArray()) {
      TreeNode child = current.getChild(ch);
      if (child == null) {
        return false;
      }

      current = child;
    }
    return true;
  }
}
