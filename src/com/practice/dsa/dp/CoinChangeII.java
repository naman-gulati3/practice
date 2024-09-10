package com.practice.dsa.dp;

import java.util.Arrays;

public class CoinChangeII {

  public static int change(int amount, int[] coins) {
    int n = coins.length;
    int[][] dp = new int[n + 1][amount + 1];
    for (int[] row : dp) {
      Arrays.fill(row, -1);
    }

    return topDown(n - 1, amount, coins, dp);
  }

  private static int topDown(int i, int amount, int[] coins, int[][] dp) {
    if (amount == 0) {
      return 1;
    }

    if (i < 0 || amount < 0) {
      return 0;
    }

    int notTake = topDown(i - 1, amount, coins, dp);
    int take = 0;
    if (coins[i] <= amount) {
      take = topDown(i, amount - coins[i], coins, dp);
    }

    dp[i][amount] = notTake + take;

    return dp[i][amount];
  }

  public static void main(String[] args) {
    // 5 + 5 + 5 + 5
    // 4 + 4 + 4 + 4 + 4
    System.out.println(change(20, new int[]{5, 4}));
  }
}
