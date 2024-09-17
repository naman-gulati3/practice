package com.practice.dsa.dp;

import java.util.Arrays;

class HouseRobber1 {

  public int rob(int[] nums) {
    int[] dp = new int[nums.length];
    int n = nums.length;
    Arrays.fill(dp, -1);

    return solve(nums, 0, dp);
  }

  private int solve(int[] nums, int i, int[] dp) {
    if (i >= nums.length) {
      return 0;
    }

    if (dp[i] != -1) {
      return dp[i];
    }

    int notRob = solve(nums, i + 1, dp);

    int rob = nums[i] + solve(nums, i + 2, dp);

    return dp[i] = Math.max(notRob, rob);
  }
}
