package com.practice.dsa.tri;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {

  class Tri {

    TreeNode root;

    public Tri() {
      this.root = new TreeNode();
    }
  }

  class TreeNode {

    TreeNode[] children;
    boolean isEndOfWord;

    public TreeNode() {
      this.children = new TreeNode[26];
      this.isEndOfWord = false;
    }

    public TreeNode getChild(char ch) {
      return children[ch - 'a'];
    }

    public void setChild(TreeNode node, char ch) {
      children[ch - 'a'] = node;
    }
  }

  public List<String> findWords(char[][] board, String[] words) {
    TreeNode root = buildTri(words);
    Set<String> res = new HashSet<>();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        dfs(board, i, j, root, "", res);
      }
    }

    return new ArrayList<>(res);
  }

  private void dfs(char[][] board, int i, int j, TreeNode root, String s, Set<String> res) {
    if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '#') {
      return;
    }

    char ch = board[i][j];
    TreeNode child = root.getChild(ch);

    if (child == null) {
      return;
    }

    s += ch;

    if (child.isEndOfWord) {
      res.add(s);
    }

    board[i][j] = '#';
    dfs(board, i + 1, j, child, s, res);
    dfs(board, i - 1, j, child, s, res);
    dfs(board, i, j + 1, child, s, res);
    dfs(board, i, j - 1, child, s, res);
    board[i][j] = ch;
  }


  private TreeNode buildTri(String[] words) {
    Tri tri = new Tri();
    for (String s : words) {
      TreeNode curr = tri.root;
      for (char ch : s.toCharArray()) {
        TreeNode child = curr.getChild(ch);
        if (child == null) {
          child = new TreeNode();
          curr.setChild(child, ch);
        }
        curr = child;
      }
      curr.isEndOfWord = true;
    }

    return tri.root;
  }
}
