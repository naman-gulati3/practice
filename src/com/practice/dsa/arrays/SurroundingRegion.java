package com.practice.dsa.arrays;

import java.util.Arrays;

public class SurroundingRegion {

  public static void solve(char[][] board) {
    // mark borders with some other character
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[0].length; col++) {
        if (board[row][col] == 'O' && (
            row == 0 || row == board.length - 1 || col == 0 || col == board[0].length - 1)) {
          capture(board, row, col);
        }
      }
    }

    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[0].length; col++) {
        if (board[row][col] == 'O') {
          board[row][col] = 'X';
        }
        if (board[row][col] == 'T') {
          board[row][col] = 'O';
        }
      }
    }

    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[0].length; col++) {

      }
    }

    System.out.println(Arrays.deepToString(board));
  }

  private static void capture(char[][] board, int row, int col) {
    if (row < 0 || col < 0 || row >= board.length || col >= board[0].length
        || board[row][col] != 'O') {
      return;
    }

    board[row][col] = 'T';

    capture(board, row + 1, col);
    capture(board, row - 1, col);
    capture(board, row, col - 1);
    capture(board, row, col + 1);
  }

  public static void main(String[] args) {
    char[][] board = new char[][]{{'X', 'X', 'X', 'X'},
        {'X', 'O', 'O', 'X'},
        {'X', 'O', 'O', 'X'},
        {'X', 'X', 'X', 'O'}};
    solve(board);
    System.out.println(Arrays.deepToString(board));
  }
}
