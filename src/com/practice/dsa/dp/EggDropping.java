package com.practice.dsa.dp;

import java.util.Arrays;

public class EggDropping {

  static int eggDrop(int n, int k) {
    int[][] dp = new int[k + 1][n + 1];
    for (int[] row : dp) {
      Arrays.fill(row, -1);
    }
    //    0 1 2 3 4 5 6 7 8 9 10
    // 0  0 0 0 0 0 0 0 0 0 0 0
    // 1  0 1 2 3 4 5 6 7 8 9 10
    // 2  0 1 2 2 3 3 3 4 4 4 4

    return topDown(n, k, dp);
  }

  private static int topDown(int eggs, int floors, int[][] dp) {
    if (floors == 0 || floors == 1) {
      return floors;
    }

    if (eggs == 1) {
      return floors;
    }

    if (dp[floors][eggs] != -1) {
      return dp[floors][eggs];
    }

    int min = Integer.MAX_VALUE;
    for (int f = 1; f <= floors; f++) {
      //                                        breaks                             unbroken(check floor above f since floors > f)
      int res = 1 + Math.max(topDown(eggs - 1, f - 1, dp), topDown(eggs, floors - f, dp));
      min = Math.min(res, min);
    }
    dp[floors][eggs] = min;
    return dp[floors][eggs];
  }

  public static void main(String[] args) {
    System.out.println(eggDrop(2, 10));
  }
}
