package com.practice.dsa.arrays;

import java.util.Arrays;

public class UniquePath {

  public static void main(String[] args) {
    System.out.println(uniquePaths(3, 7));
    System.out.println(uniquePathsMemoization(3, 7));
  }

  // all possible ways to move from top left to bottom right of grid (only down and right allowed)
  private static int uniquePaths(int m, int n) {
    int[][] dp = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 1;
        } else {
          dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        }
      }
    }
    return dp[m - 1][n - 1];
  }

  public static int uniquePathsMemoization(int m, int n) {
    int[][] dp = new int[m][n];
    for (int[] row : dp) {
      Arrays.fill(row, -1);
    }

    return topDown(dp, m - 1, n - 1);
  }

  private static int topDown(int[][] dp, int row, int col) {
    // if row is 0 or col is 0 where is only 1 way to get to destination i.e
    // if row is 0 we can only move down and nowhere else
    // if col is 0 we can only move right and nowhere else
    if (row == 0 || col == 0) {
      return 1;
    }

    if (dp[row][col] != -1) {
      return dp[row][col];
    }

    // move up
    int up = topDown(dp, row - 1, col);
    // move left
    int left = topDown(dp, row, col - 1);
    dp[row][col] = up + left;

    return dp[row][col];
  }
}
