package com.practice.dsa.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Knapsack {

  public static int maxProfit(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) {
    int[][] dp = new int[n][w + 1];
    for (int[] rows : dp) {
      Arrays.fill(rows, -1);
    }
    return knapsack(values, weights, n - 1, w, dp);
  }

  private static int knapsack(
      ArrayList<Integer> values, ArrayList<Integer> weights, int idx, int w, int[][] dp) {
    if (idx == 0) {
      if (weights.get(0) <= w) {
        return values.get(0);
      } else {
        return 0;
      }
    }

    if (dp[idx][w] != -1) {
      return dp[idx][w];
    }

    int notTaken = 0 + knapsack(values, weights, idx - 1, w, dp);

    int taken = Integer.MIN_VALUE;
    if (weights.get(idx) <= w) {
      taken = values.get(idx) + knapsack(values, weights, idx - 1, w - weights.get(idx), dp);
    }

    dp[idx][w] = Math.max(taken, notTaken);

    return dp[idx][w];
  }

  // bottom up
  private static int knapsackTabulation(
      ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) {
    int[][] dp = new int[n][w + 1];

    for (int wt = weights.get(0); wt <= w; wt++) {
      dp[0][wt] = values.get(0);
    }

    for (int idx = 1; idx < n; idx++) {
      for (int wt = 0; wt <= w; wt++) {
        int notTaken = 0 + dp[idx - 1][wt];

        int taken = Integer.MIN_VALUE;
        if (weights.get(idx) <= wt) {
          taken = values.get(idx) + dp[idx - 1][wt - weights.get(idx)];
        }
        dp[idx][wt] = Math.max(taken, notTaken);
      }
    }
    return dp[n - 1][w];
  }

  public static void main(String[] args) {
    ArrayList<Integer> wt = new ArrayList<>(List.of(1, 2, 4, 5));
    ArrayList<Integer> val = new ArrayList<>(List.of(5, 4, 8, 6));
    int W = 5;
    int n = wt.size();

    // Calculate and print the maximum value of items the thief can steal
    System.out.println(
        "The Maximum value of items the thief can steal is " + maxProfit(val, wt, n, W));

    System.out.println(knapsackTabulation(val, wt, n, W));
  }
}
