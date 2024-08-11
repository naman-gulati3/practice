package com.practice.dsa.dp;

import java.util.Arrays;

public class MaxSumIncreasingSubsequence {

  public static int maxSumIS(int[] arr, int n) {
    int[] dp = new int[n];

    // Initialize dp array with the array values as every element is an increasing subsequence of length 1
    for (int i = 0; i < n; i++) {
      dp[i] = arr[i];
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (arr[j] < arr[i]) {
          dp[i] = Math.max(dp[i], dp[j] + arr[i]);
        }
      }
    }

    return Arrays.stream(dp).max().getAsInt();
  }

  public static int maxSumISTopDown(int[] arr, int n) {
    int[][] dp = new int[n + 1][n + 1];

    // Initialize dp array with the array values as every element is an increasing subsequence of length 1
    for (int[] rows : dp) {
      Arrays.fill(rows, -1);
    }

    return solve(0, -1, arr, dp);
  }

  private static int solve(int idx, int prevIdx, int[] arr, int[][] dp) {
    if (idx == arr.length) {
      return 0;
    }

    if (dp[idx][prevIdx + 1] != -1) {
      return dp[idx][prevIdx + 1];
    }

    int notTake = solve(idx + 1, prevIdx, arr, dp);
    int take = 0;
    if (prevIdx == -1 || arr[idx] > arr[prevIdx]) {
      take = arr[idx] + solve(idx + 1, idx, arr, dp);
    }
    dp[idx][prevIdx + 1] = Math.max(take, notTake);

    return dp[idx][prevIdx + 1];
  }

  public static void main(String[] args) {
    System.out.println(maxSumIS(new int[]{1, 101, 2, 3, 100}, 5));
    System.out.println(maxSumISTopDown(new int[]{1, 101, 2, 3, 100}, 5));
  }
}
