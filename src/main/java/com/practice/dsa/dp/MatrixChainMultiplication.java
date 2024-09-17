package com.practice.dsa.dp;

import java.util.Arrays;

public class MatrixChainMultiplication {

  static int matrixMultiplication(int N, int[] arr) {
    int[][] dp = new int[N][N];
    for (int[] rows : dp) {
      Arrays.fill(rows, -1);
    }
    return solve(1, N - 1, arr, dp);
  }

  private static int solve(int i, int j, int[] arr, int[][] dp) {
    if (i == j) {
      return 0;
    }
    if (dp[i][j] != -1) {
      return dp[i][j];
    }

    int min = Integer.MAX_VALUE;

    for (int k = i; k < j; k++) {
      int steps = arr[i - 1] * arr[k] * arr[j] + solve(i, k, arr, dp) + solve(k + 1, j, arr, dp);
      min = Math.min(min, steps);
    }
    dp[i][j] = min;
    return min;
  }

  static int matrixMultiplicationBottomUp(int N, int[] arr) {
    int[][] dp = new int[N][N];
    // fill out diagonals with zeros because there is nothing to multiply with the matrix itself
    for (int i = 0; i < N; i++) {
      dp[i][i] = 0;
    }

    for (int i = N - 1; i >= 1; i--) {
      for (int j = i + 1; j < N; j++) {
        int min = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
          int steps = arr[i - 1] * arr[k] * arr[j] + dp[i][k] + dp[k + 1][j];
          min = Math.min(min, steps);
        }
        dp[i][j] = min;
      }
    }
    return dp[1][N - 1];
  }

  public static void main(String[] args) {
    System.out.println(matrixMultiplication(5, new int[] {40, 20, 30, 10, 30})); // 26000
    System.out.println(matrixMultiplicationBottomUp(5, new int[] {40, 20, 30, 10, 30})); // 26000
  }
}
