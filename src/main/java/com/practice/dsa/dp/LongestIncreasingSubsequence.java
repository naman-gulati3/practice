package com.practice.dsa.dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

  public static int lengthOfLIS(int[] nums) {
    // top down memoization
    int[][] dp = new int[nums.length + 1][nums.length + 1];
    for (int[] rows : dp) {
      Arrays.fill(rows, -1);
    }

    return solve(0, -1, nums, nums.length, dp);
  }

  private static int solve(int idx, int prevIdx, int[] nums, int n, int[][] dp) {
    if (idx == n) {
      return 0;
    }

    // prev + 1 because it is adjusted for -1 index by moving forward 1 position in array
    if (dp[idx][prevIdx + 1] != -1) {
      return dp[idx][prevIdx + 1];
    }

    int notTake = 0 + solve(idx + 1, prevIdx, nums, n, dp); // not take

    int take = 0;

    if (prevIdx == -1 || nums[idx] > nums[prevIdx]) {
      take = 1 + solve(idx + 1, idx, nums, n, dp); // take
    }
    dp[idx][prevIdx + 1] = Math.max(notTake, take); // take

    return dp[idx][prevIdx + 1];
  }

  public static void main(String[] args) {
    System.out.println(lengthOfLIS(new int[] {10, 9, 2, 5, 3, 7, 101, 18})); // 4
  }
}
