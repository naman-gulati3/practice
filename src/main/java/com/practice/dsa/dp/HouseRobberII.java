package com.practice.dsa.dp;

import java.util.Arrays;

public class HouseRobberII {

  public static int rob(int[] nums) {
    int n = nums.length;
    if (n == 1) {
      return nums[0];
    }
    int[] dp1 = new int[n];
    int[] dp2 = new int[n];
    Arrays.fill(dp1, -1);
    Arrays.fill(dp2, -1);

    int max1 = topDown(nums, 0, n - 2, dp1);
    int max2 = topDown(nums, 1, n - 1, dp2);

    return Math.max(max1, max2);
  }

  private static int topDown(int[] nums, int start, int end, int[] dp) {
    if (start > end) {
      return 0;
    }

    if (dp[start] != -1) {
      return dp[start];
    }

    int pick = nums[start] + topDown(nums, start + 2, end, dp);
    int notPick = topDown(nums, start + 1, end, dp);

    dp[start] = Math.max(pick, notPick);
    return dp[start];
  }

  public static void main(String[] args) {
    System.out.println(rob(new int[] {1, 2, 3, 1}));
  }
}
