package com.practice.dsa.dp;

import java.util.Arrays;

public class CherryPickup {

  public static int cherryPickup(int[][] grid) {
    int n = grid.length;
    int[][][][] dp = new int[n][n][n][n];
    for (int[][][] row : dp) {
      for (int[][] r : row) {
        for (int[] c : r) {
          Arrays.fill(c, -1);
        }
      }
    }

    int ans = solve(grid, 0, 0, 0, 0, dp);
    return Math.max(0, ans);
  }


  // (r1, c1) and (r2, c2) are two guy going from 0, 0 to (n - 1, m - 1)
  private static int solve(int[][] grid, int r1, int c1, int r2, int c2, int[][][][] dp) {
    if (r1 >= grid.length || c1 >= grid[0].length || r2 >= grid.length || c2 >= grid[0].length
        || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
      return Integer.MIN_VALUE;
    }

    if (dp[r1][c1][r2][c2] != -1) {
      return dp[r1][c1][r2][c2];
    }

    if (r1 == grid.length - 1 && c1 == grid[0].length - 1) {
      return grid[r1][c1];
    }

    int cherries = 0;
    // both are at same spot. Ony 1 can pick the cherry
    if (r1 == r2 && c1 == c2) {
      cherries += grid[r1][c1];
    } else {
      cherries += grid[r1][c1] + grid[r2][c2];
    }

    int path1 = solve(grid, r1 + 1, c1, r2 + 1, c2, dp); // down, down
    int path2 = solve(grid, r1, c1 + 1, r2, c2 + 1, dp); // right, right
    int path3 = solve(grid, r1 + 1, c1, r2, c2 + 1, dp); // down, right
    int path4 = solve(grid, r1, c1 + 1, r2 + 1, c2, dp); // right, down

    cherries += Math.max(Math.max(path1, path2), Math.max(path3, path4));
    dp[r1][c1][r2][c2] = cherries;

    return cherries;
  }

  public static void main(String[] args) {
    int[][] grid = new int[][]{{1, 1, -1}, {1, -1, 1}, {-1, 1, 1}};
    System.out.println(cherryPickup(grid));
  }
}
