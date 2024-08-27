package com.practice.dsa.greedy;

import java.util.Arrays;

public class MinimumNumberOfCoins {

  public static int minCoinsDp(int[] coins, int M, int V) {
    int[] dp = new int[V + 1];
    Arrays.fill(dp, -1);

    return solve(coins, M, V, dp);
  }

  private static int solve(int[] coins, int M, int V, int[] dp) {
    if (V == 0) {
      return 0;
    }

    if (dp[V] != -1) {
      return dp[V];
    }

    int res = Integer.MAX_VALUE;
    for (int i = 0; i < M; i++) {
      if (coins[i] <= V) {
        int subResult = solve(coins, M, V - coins[i], dp);

        // some subRes is found and it is better than existing res
        if (subResult != Integer.MAX_VALUE && subResult + 1 < res) {
          res = subResult + 1;
        }
      }
    }
    dp[V] = res;
    return res;
  }


  public static int minCoins(int[] coins, int M, int V) {
    Arrays.sort(coins);

    int pickedCoin = -1;
    int coinCount = 0;

    while (V >= 0) {
      if (V == 0) {
        break;
      }
      int i = 0;
      while (i < M && coins[i] <= V) {
        // pick the maximum possible coin
        pickedCoin = coins[i];
        i++;
      }
      coinCount++;
      V -= pickedCoin;
    }

    return V == 0 ? coinCount : -1;
  }

  public static int minCoinsDp2(int[] coins, int M, int V) {
    int[][] dp = new int[M + 1][V + 1];
    for (int[] rows : dp) {
      Arrays.fill(rows, -1);
    }

    int numCoins = solve2(coins, M - 1, V, dp);
    return numCoins == Integer.MAX_VALUE ? -1 : numCoins;
  }

  private static int solve2(int[] coins, int M, int V, int[][] dp) {
    if (M == 0) {
      if (V % coins[0] == 0) {
        return V / coins[0];
      }
      return Integer.MAX_VALUE;
    }

    if (dp[M][V] != -1) {
      return dp[M][V];
    }

    // not pick
    int notPick = solve2(coins, M - 1, V, dp);

    int pick = Integer.MAX_VALUE;

    if (coins[M] <= V) {
      int result = solve2(coins, M, V - coins[M], dp);
      if (result != Integer.MAX_VALUE) {
        pick = 1 + result;
      }
    }
    dp[M][V] = Math.min(pick, notPick);
    return dp[M][V];
  }


  public static void main(String[] args) {
    //    0  1 2  3
    // 0  0  0 0  0
    // 1  0  1 0  0
    // 2  0  2 1  0
    // 3  0  3 2  1
    // 4  0  4 2  2
    // 5  0  5 2  2
    // 6  0  6 3  2
    // 7  0
    // 8  0
    // 9  0
    // 10 0
    // 11 0

    System.out.println(minCoins(new int[]{9, 6, 5, 1}, 4, 11));
    System.out.println(minCoinsDp(new int[]{9, 6, 5, 1}, 4, 11));
    System.out.println(minCoinsDp2(new int[]{9, 6, 5, 1}, 4, 11));
  }
}
