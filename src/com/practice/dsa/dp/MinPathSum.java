package com.practice.dsa.dp;

import java.util.Arrays;

public class MinPathSum {

  public static int minPathSum(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;

    int[][] dp = new int[n][m];
    for (int[] rows : dp) {
      Arrays.fill(rows, -1);
    }

    return topDown(n - 1, m - 1, grid, dp);
  }

  private static int topDown(int i, int j, int[][] grid, int[][] dp) {
    if (i == 0 && j == 0) {
      return grid[i][j];
    }
    if (i < 0 || j < 0) {
      // return a huge value so that this is a path which cannot give min sum path
      return (int) Math.pow(10, 9);
    }
    if (dp[i][j] != -1) {
      return dp[i][j];
    }

    int up = grid[i][j] + topDown(i - 1, j, grid, dp);
    int left = grid[i][j] + topDown(i, j - 1, grid, dp);
    dp[i][j] = Math.min(up, left);
    return dp[i][j];
  }

  public static int minPathSumBottomUp(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;

    int[][] dp = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (i == 0 && j == 0) {
          dp[i][j] = grid[i][j];
        } else {
          int up = grid[i][j];
          if (i > 0) {
            up += dp[i - 1][j];
          } else {
            up += (int) Math.pow(10, 9);
          }

          int left = grid[i][j];
          if (j > 0) {
            left += dp[i][j - 1];
          } else {
            left += (int) Math.pow(10, 9);
          }
          dp[i][j] = Math.min(left, up);
        }
      }
    }
    return dp[n - 1][m - 1];
  }


  public static void main(String[] args) {
    // 1 3 1
    // 1 5 1
    // 4 2 1
    int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
    System.out.println(minPathSum(grid));
    System.out.println(minPathSumBottomUp(grid));
  }
}
