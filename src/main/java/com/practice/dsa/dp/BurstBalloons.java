package com.practice.dsa.dp;

import java.util.Arrays;

public class BurstBalloons {

  public static int maxCoins(int[] nums) {
    int[] updated = new int[nums.length + 2];
    updated[0] = 1;
    updated[updated.length - 1] = 1;

    for (int i = 1; i <= nums.length; i++) {
      updated[i] = nums[i - 1];
    }

    int[][] dp = new int[updated.length + 1][updated.length + 1];
    for (int[] row : dp) {
      Arrays.fill(row, -1);
    }

    return topDown(1, nums.length, dp, updated);
  }

  private static int topDown(int i, int j, int[][] dp, int[] updated) {
    if (i > j) {
      return 0;
    }

    if (dp[i][j] != -1) {
      return dp[i][j];
    }

    int max = Integer.MIN_VALUE;
    for (int k = i; k <= j; k++) {
      max =
          Math.max(
              max,
              updated[i - 1] * updated[k] * updated[j + 1]
                  + topDown(i, k - 1, dp, updated)
                  + topDown(k + 1, j, dp, updated));
    }
    dp[i][j] = max;
    return dp[i][j];
  }

  public static void main(String[] args) {
    System.out.println(maxCoins(new int[] {3, 1, 5, 8})); // 167
    // nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
    // coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
  }
}
