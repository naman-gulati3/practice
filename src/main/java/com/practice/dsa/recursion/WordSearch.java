package com.practice.dsa.recursion;

public class WordSearch {

  public static boolean exist(char[][] board, String word) {
    int n = board.length;
    int m = board[0].length;

    boolean[][] visited = new boolean[n][m];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (word.charAt(0) == board[i][j]) {
          if (dfs(board, word, i, j, 0, visited)) {
            return true;
          }
        }
      }
    }
    return false;
  }

  private static boolean dfs(
      char[][] board, String word, int r, int c, int i, boolean[][] visited) {
    if (i == word.length()) {
      return true;
    }

    if (r < 0
        || c < 0
        || r >= board.length
        || c >= board[0].length
        || visited[r][c]
        || word.charAt(i) != board[r][c]) {
      return false;
    }

    visited[r][c] = true;
    if (dfs(board, word, r + 1, c, i + 1, visited)
        || dfs(board, word, r - 1, c, i + 1, visited)
        || dfs(board, word, r, c + 1, i + 1, visited)
        || dfs(board, word, r, c - 1, i + 1, visited)) {
      return true;
    }
    visited[r][c] = false;

    return false;
  }

  public static void main(String[] args) {
    System.out.println(
        exist(
            new char[][] {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}},
            "ABCCED"));
  }
}
