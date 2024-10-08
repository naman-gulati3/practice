package com.practice.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueen {

  public static List<List<String>> solveNQueens(int n) {
    List<List<String>> result = new ArrayList<>();
    char[][] board = new char[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        board[i][j] = '.';
      }
    }
    recurse(result, 0, board);
    return result;
  }

  private static void recurse(List<List<String>> result, int row, char[][] board) {
    if (row == board.length) {
      List<String> list = new ArrayList<>();
      for (int i = 0; i < board.length; i++) {
        StringBuilder builder = new StringBuilder();
        for (int j = 0; j < board.length; j++) {
          builder.append(board[i][j]);
        }
        list.add(builder.toString());
      }
      result.add(list);
      return;
    }

    for (int col = 0; col < board.length; col++) {
      if (isSafe(board, row, col)) {
        board[row][col] = 'Q';
        recurse(result, row + 1, board);
        board[row][col] = '.';
      }
    }
  }

  private static boolean isSafe(char[][] board, int row, int col) {
    int n = board.length;

    // check if column is safe for each row
    for (int i = 0; i < row; i++) {
      if (board[i][col] == 'Q') {
        return false;
      }
    }

    // left upper diagonal
    for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
      if (board[i][j] == 'Q') {
        return false;
      }
    }

    // right upper diagonal
    for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
      if (board[i][j] == 'Q') {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(solveNQueens(4));
  }
}
