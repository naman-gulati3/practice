package com.practice.dsa.dp;

import java.util.Arrays;

public class RodCuttingMaxPrice {

  public static int cutRod(int[] price, int n) {
    int[][] dp = new int[price.length][n + 1];

    for (int[] row : dp) {
      Arrays.fill(row, -1);
    }

    return topDown(price.length - 1, price, n, dp);
  }

  private static int topDown(int idx, int[] price, int n, int[][] dp) {
    if (idx == 0) {
      return n * price[0];
    }

    if (dp[idx][n] != -1) {
      return dp[idx][n];
    }

    int notTake = topDown(idx - 1, price, n, dp);
    int take = Integer.MIN_VALUE;
    int rodLength = idx + 1;
    if (rodLength <= n) {
      take = price[idx] + topDown(idx, price, n - rodLength, dp);
    }
    dp[idx][n] = Math.max(take, notTake);
    return dp[idx][n];
  }

  public static void main(String[] args) {
    System.out.println(cutRod(new int[] {2, 5, 7, 8, 9}, 5));
  }
}
