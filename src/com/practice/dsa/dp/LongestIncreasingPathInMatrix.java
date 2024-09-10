package com.practice.dsa.dp;

import java.util.Arrays;

public class LongestIncreasingPathInMatrix {

  public static int longestIncreasingPath(int[][] matrix) {
    int maxPath = Integer.MIN_VALUE;
    int[][] dp = new int[matrix.length][matrix[0].length];

    for (int[] row : dp) {
      Arrays.fill(row, -1);
    }

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        int currentMax = dfs(matrix, i, j, -1, dp);
        maxPath = Math.max(maxPath, currentMax);
      }
    }

    return maxPath;
  }


  private static int dfs(int[][] matrix, int row, int col, int prev, int[][] dp) {
    if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length) {
      return 0;
    }

    if (prev >= matrix[row][col]) {
      return 0;
    }

    if (dp[row][col] != -1) {
      return dp[row][col];
    }

    int curr = matrix[row][col];

    int top = dfs(matrix, row - 1, col, curr, dp);
    int down = dfs(matrix, row + 1, col, curr, dp);
    int left = dfs(matrix, row, col - 1, curr, dp);
    int right = dfs(matrix, row, col + 1, curr, dp);

    int max = Math.max(Math.max(top, down), Math.max(left, right));
    dp[row][col] = max + 1;
    return dp[row][col];
  }

  public static void main(String[] args) {
    int[][] matrix = new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};

    System.out.println(longestIncreasingPath(matrix));
  }
}
