package com.practice.dsa.tri;

public class WordDictionary {

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

    public void setChild(TreeNode node, char ch) {
      this.nodes[ch - 'a'] = node;
    }
  }

  public WordDictionary() {
    tri = new Tri();
  }

  public void addWord(String word) {
    TreeNode current = tri.root;
    for (char ch : word.toCharArray()) {
      TreeNode child = current.getChild(ch);
      if (child == null) {
        child = new TreeNode();
        current.setChild(child, ch);
      }

      current = child;
    }
    current.isEndOfWord = true;
  }

  public boolean search(String word) {
    return searchInNode(word, 0, tri.root);
  }

  private boolean searchInNode(String word, int i, TreeNode current) {
    if (i == word.length()) {
      return current.isEndOfWord;
    }

    char ch = word.charAt(i);
    if (ch == '.') {
      // if char is '.' get all nodes of current and search in all branches
      // for eg. for string ".ay" if first char is . search across all branches of tri following "ay"
      // for eg. for string "b.." search in all branches of b of length 3 where endOfWord is also true
      for (TreeNode child : current.nodes) {
        if (child != null && searchInNode(word, i + 1, child)) {
          return true;
        }
      }
      return false;
    }

    TreeNode child = current.getChild(ch);
    if (child == null) {
      return false;
    }

    return searchInNode(word, i + 1, child);
  }

  public static void main(String[] args) {
    WordDictionary wordDictionary = new WordDictionary();
    wordDictionary.addWord("day");
    wordDictionary.addWord("bay");
    wordDictionary.addWord("may");
    System.out.println(wordDictionary.search("say")); // return false
    System.out.println(wordDictionary.search("day")); // return true
    System.out.println(wordDictionary.search(".ay")); // return true
    System.out.println(wordDictionary.search("b..")); // return true
  }
}
