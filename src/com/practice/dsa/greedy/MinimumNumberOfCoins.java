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

  public static void main(String[] args) {
    System.out.println(minCoins(new int[]{9, 6, 5, 1}, 4, 11));
    System.out.println(minCoinsDp(new int[]{9, 6, 5, 1}, 4, 11));
  }
}
