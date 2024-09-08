package com.practice.dsa.dp;

import java.util.Arrays;

public class KnightProbability {

  private static final int[][] moves = new int[][]{{-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1},
      {2, -1}, {1, -2}, {-1, -2}};

  public static double knightProbability(int n, int k, int row, int col) {
    double[][][] dp = new double[n][n][k + 1];

    for (double[][] rows : dp) {
      for (double[] cols : rows) {
        Arrays.fill(cols, -1);
      }
    }
    return traverse(n, k, row, col, dp);
  }

  private static double traverse(int n, int k, int row, int col, double[][][] dp) {
    if (row < 0 || col < 0 || row >= n || col >= n) {
      return 0;
    }

    if (k == 0) {
      return 1;
    }

    if (dp[row][col][k] != -1) {
      return dp[row][col][k];
    }

    double result = 0;
    for (int[] move : moves) {
      int newRow = row + move[0];
      int newCol = col + move[1];

      result += traverse(n, k - 1, newRow, newCol, dp);
    }

    dp[row][col][k] = result / 8.0;
    return dp[row][col][k];
  }

  public static void main(String[] args) {
    System.out.println(knightProbability(3, 2, 0, 0));
  }
}
