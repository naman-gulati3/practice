package com.practice.dsa.dp;

import java.util.Arrays;

public class RodCuttingMinCost {

  public static int minCost(int n, int[] cuts) {
    Arrays.sort(cuts);
    int[] updated = new int[cuts.length + 2];
    updated[0] = 0;
    for (int i = 1; i <= cuts.length; i++) {
      updated[i] = cuts[i - 1];
    }

    updated[updated.length - 1] = n;

    System.out.println(Arrays.toString(updated));

    int[][] dp = new int[updated.length][updated.length];

    for (int[] row : dp) {
      Arrays.fill(row, -1);
    }

    return topDown(1, cuts.length, updated, dp);
  }

  private static int topDown(int i, int j, int[] cuts, int[][] dp) {
    if (i > j) {
      return 0;
    }

    if (dp[i][j] != -1) {
      return dp[i][j];
    }

    int min = Integer.MAX_VALUE;
    for (int idx = i; idx <= j; idx++) {
      int cost =
          (cuts[j + 1] - cuts[i - 1])
              + topDown(i, idx - 1, cuts, dp)
              + topDown(idx + 1, j, cuts, dp);
      min = Math.min(min, cost);
    }
    dp[i][j] = min;
    return dp[i][j];
  }

  public static void main(String[] args) {
    System.out.println(minCost(7, new int[] {3, 1, 4, 5}));
  }
}
