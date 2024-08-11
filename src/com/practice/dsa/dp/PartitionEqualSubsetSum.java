package com.practice.dsa.dp;

import java.util.Arrays;

public class PartitionEqualSubsetSum {

  public static boolean canPartition(int[] nums) {
    int totalSum = Arrays.stream(nums).sum();
    int n = nums.length;
    // cannot partition array when sum is odd
    if (totalSum % 2 == 1) {
      return false;
    } else {
      totalSum = totalSum / 2;
      int[][] dp = new int[n][totalSum + 1];
      for (int[] row : dp) {
        Arrays.fill(row, -1);
      }

      return topDown(nums, totalSum, dp, n - 1);
    }
  }

  private static boolean topDown(int[] nums, int total, int[][] dp, int idx) {
    if (total == 0) {
      return true;
    }
    if (idx < 0 || total < 0) {
      return false;
    }

    if (dp[idx][total] != -1) {
      return dp[idx][total] == 1;
    }

    boolean notTake = topDown(nums, total, dp, idx - 1);
    boolean take = false;

    if (nums[idx] <= total) {
      take = topDown(nums, total - nums[idx], dp, idx - 1);
    }

    dp[idx][total] = notTake || take ? 1 : 0;
    return notTake || take;
  }

  public static void main(String[] args) {
    System.out.println(canPartition(new int[]{1, 4, 5}));
  }
}
