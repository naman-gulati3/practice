package com.practice.dsa.tri;

public class AddAndSearchDataStructure {

  static class WordDictionary {

    Tri tri;

    static class Tri {

      TreeNode root;

      public Tri() {
        root = new TreeNode();
      }
    }

    static class TreeNode {

      TreeNode[] nodes;
      boolean isEndOfWord;

      public TreeNode() {
        this.nodes = new TreeNode[26];
        this.isEndOfWord = false;
      }

      public TreeNode getChild(char ch) {
        return this.nodes[ch - 'a'];
      }

      public void setChild(TreeNode child, char ch) {
        this.nodes[ch - 'a'] = child;
      }

      public void setEndOfWord(boolean isEndOfWord) {
        this.isEndOfWord = isEndOfWord;
      }
    }

    public WordDictionary() {
      tri = new Tri();
    }

    public void addWord(String word) {
      TreeNode children = tri.root;

      for (char ch : word.toCharArray()) {
        TreeNode current = children.getChild(ch);
        if (current == null) {
          current = new TreeNode();
          children.setChild(current, ch);
        }
        children = current;
      }
      children.setEndOfWord(true);
    }

    public boolean search(String word) {
      return searchInNode(word, 0, tri.root);
    }

    private boolean searchInNode(String word, int idx, TreeNode node) {
      if (idx == word.length()) {
        return node.isEndOfWord;
      }

      char ch = word.charAt(idx);
      if (ch == '.') {
        for (TreeNode child : node.nodes) {
          if (child != null && searchInNode(word, idx + 1, child)) {
            return true;
          }
        }
        return false;
      }

      TreeNode child = node.getChild(ch);
      if (child == null) {
        return false;
      }
      return searchInNode(word, idx + 1, child);
    }
  }

  public static void main(String[] args) {
    WordDictionary wd = new WordDictionary();
    wd.addWord("apple");
    wd.addWord("naman");
    System.out.println(wd.search("..man"));
    System.out.println(wd.search("app.."));
  }
}
