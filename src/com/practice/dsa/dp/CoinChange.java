package com.practice.dsa.dp;

import java.util.Arrays;

public class CoinChange {

  public static int coinChange(int[] coins, int amount) {
    int n = coins.length;
    int[][] dp = new int[n][amount + 1];
    for (int[] rows : dp) {
      Arrays.fill(rows, -1);
    }

    int result = topDown(n - 1, coins, amount, dp);
    return result == Integer.MAX_VALUE ? -1 : result;
  }

  private static int topDown(int idx, int[] coins, int amount, int[][] dp) {
    if (amount == 0) {
      return 0;
    }

    if (idx < 0) {
      // no solution
      return Integer.MAX_VALUE;
    }

    if (dp[idx][amount] != -1) {
      return dp[idx][amount];
    }

    int notTake = topDown(idx - 1, coins, amount, dp);

    int take = Integer.MAX_VALUE;
    if (coins[idx] <= amount) {
      int result = topDown(idx, coins, amount - coins[idx], dp);
      if (result != Integer.MAX_VALUE) {
        take = 1 + result;
      }
    }
    dp[idx][amount] = Math.min(notTake, take);
    return dp[idx][amount];
  }

  public static int coinChangeBottomUp(int[] coins, int amount) {
    int n = coins.length;
    int[][] dp = new int[n][amount + 1];
    for (int i = 0; i <= amount; i++) {
      if (amount % coins[0] == 0) {
        dp[0][i] = 1;
      }
    }

    for (int i = 1; i < n; i++) {
      for (int target = 0; target <= amount; target++) {
        int notTaken = dp[i - 1][target];

        int taken = 0;
        if (coins[i] <= target) {
          taken = dp[i][target - coins[i]];
        }
        dp[i][target] = notTaken + taken;
      }
    }
    return dp[n - 1][amount];
  }

  public static void main(String[] args) {
    System.out.println(coinChange(new int[]{1, 2, 5}, 11));
    System.out.println(coinChangeBottomUp(new int[]{1, 2, 5}, 11));

  }
}
