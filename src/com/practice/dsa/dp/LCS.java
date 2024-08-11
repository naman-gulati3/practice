package com.practice.dsa.dp;


import java.util.Arrays;

// longest common subsequence
public class LCS {

  public static void main(String[] args) {
    System.out.println(longestCommonSubsequence("abcde", "ace"));
    System.out.println(bottomUpTabulation("abcde", "ace"));
  }

  public static int longestCommonSubsequence(String text1, String text2) {
    int n = text1.length();
    int m = text2.length();

    int[][] dp = new int[n][m];
    for (int[] rows : dp) {
      Arrays.fill(rows, -1);
    }

    return topDownMemoization(text1, n - 1, text2, m - 1, dp);
  }

  private static int topDownMemoization(String text1, int n, String text2, int m, int[][] dp) {
    if (n < 0 || m < 0) {
      return 0;
    }

    if (dp[n][m] != -1) {
      return dp[n][m];
    }

    if (text1.charAt(n) == text2.charAt(m)) {
      dp[n][m] = 1 + topDownMemoization(text1, n - 1, text2, m - 1, dp);
      return dp[n][m];
    }
    dp[n][m] = 0 + Math.max(topDownMemoization(text1, n - 1, text2, m, dp),
        topDownMemoization(text1, n, text2, m - 1, dp));
    return dp[n][m];
  }

  private static int bottomUpTabulation(String text1, String text2) {
    int n = text1.length();
    int m = text2.length();

    int[][] dp = new int[n + 1][m + 1];
    // Initialize the first columns of each rows zeros since LCS with an empty string is zero
    for (int i = 0; i <= n; i++) {
      dp[i][0] = 0;
    }

    // Initialize the first row of with zeros since LCS with an empty string is zero
    for (int i = 0; i <= m; i++) {
      dp[0][i] = 0;
    }

    for (int idx1 = 1; idx1 <= n; idx1++) {
      for (int idx2 = 1; idx2 <= m; idx2++) {
        if (text1.charAt(idx1 - 1) == text2.charAt(idx2 - 1)) {
          dp[idx1][idx2] = 1 + dp[idx1 - 1][idx2 - 1];
        } else {
          dp[idx1][idx2] = 0 + Math.max(dp[idx1 - 1][idx2], dp[idx1][idx2 - 1]);
        }
      }
    }
    return dp[n][m];
  }
}
