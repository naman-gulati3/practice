package com.practice.dsa.dp;

import java.util.Arrays;

public class TargetSum {

  public static int findTargetSumWays(int[] nums, int target) {
    int n = nums.length;
    int total = Arrays.stream(nums).sum();

    if (total - target < 0) {
      return 0;
    }

    if ((total - target) % 2 == 1) {
      return 0;
    }

    int num = (total + target) / 2;
    int[][] dp = new int[n][total + 1];

    for (int[] row : dp) {
      Arrays.fill(row, -1);
    }

    return topDown(nums, n - 1, num, dp);
  }

  private static int topDown(int[] nums, int n, int target, int[][] dp) {
    if (n == 0) {
      // you can add 0 or subtract 0 to get to target
      if (target == 0 && nums[0] == 0) {
        return 2;
      }

      if (target == 0 || target == nums[0]) {
        return 1;
      }
      return 0;
    }

    if (dp[n][target] != -1) {
      return dp[n][target];
    }

    int notTake = topDown(nums, n - 1, target, dp);
    int take = 0;
    if (nums[n] <= target) {
      take = topDown(nums, n - 1, target - nums[n], dp);
    }

    dp[n][target] = notTake + take;

    return dp[n][target];
  }

  public static void main(String[] args) {
    System.out.println(findTargetSumWays(new int[] {1, 2, 1}, 0));
    // -1 - 1 + 2
    // +1 + 1 - 2
    System.out.println(findTargetSumWays(new int[] {7, 9, 3, 8, 0, 2, 4, 8, 3, 9}, 0));
  }
}
// 1 + 1 - 1 - 1 + 1
// 1 - 1 + 1 + 1 - 1
// 1 + 1 + 1 - 1 - 1
// 1 + 1 - 1 + 1 - 1

//   0 1 2 3
// 0 0 0 0 0
// 1 0 5
// 2 0
// 3 0
// 4 0
