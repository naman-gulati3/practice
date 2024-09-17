package com.practice.dsa.arrays;

import java.util.Arrays;

public class GameOfLife {

  private static final int die = 2;
  private static final int alive = 3;
  private static final int[][] directions =
      new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

  public static void gameOfLife(int[][] board) {
    int rows = board.length;
    int cols = board[0].length;

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        int around = countAlive(i, j, board);

        if (board[i][j] == 0 && around == 3) {
          board[i][j] = alive;
        } else if (board[i][j] == 1) {
          if (around < 2 || around > 3) {
            board[i][j] = die;
          }
        }
      }
    }

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (board[i][j] == die) {
          board[i][j] = 0;
        }

        if (board[i][j] == alive) {
          board[i][j] = 1;
        }
      }
    }
  }

  private static int countAlive(int row, int col, int[][] board) {
    int count = 0;

    for (int[] dir : directions) {
      int newRow = row + dir[0];
      int newCol = col + dir[1];

      if (newRow >= 0 && newCol >= 0 && newRow < board.length && newCol < board[0].length) {
        // the cell was actually alive, but we marked it dead because alive count around is < 2 || >
        // 3
        if (board[newRow][newCol] == 1 || board[newRow][newCol] == die) {
          count++;
        }
      }
    }

    return count;
  }

  public static void main(String[] args) {
    int[][] board = new int[][] {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
    gameOfLife(board);
    System.out.println(Arrays.deepToString(board));
  }
}
