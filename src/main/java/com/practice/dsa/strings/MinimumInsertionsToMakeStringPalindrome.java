package com.practice.dsa.strings;

import java.util.Arrays;

public class MinimumInsertionsToMakeStringPalindrome {

  public static int solve(String s) {
    StringBuilder sb = new StringBuilder(s);
    String reversed = sb.reverse().toString();

    //    int lcs = lcs(s, reversed);
    int lcs = lcsMemoization(s, reversed);

    // lcs will be length to string minus the longest common substring
    return s.length() - lcs;
  }

  // bottom up
  private static int lcs(String s1, String s2) {
    int n = s1.length();
    int m = s2.length();
    int[][] dp = new int[n + 1][m + 1];

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[n][m];
  }

  private static int lcsMemoization(String s1, String s2) {
    int n = s1.length();
    int m = s2.length();
    int[][] dp = new int[m + 1][n + 1];
    for (int[] row : dp) {
      Arrays.fill(row, -1);
    }

    return topDown(dp, s1, s2, m - 1, n - 1);
  }

  private static int topDown(int[][] dp, String s1, String s2, int m, int n) {
    if (m < 0 || n < 0) {
      return 0;
    }

    if (dp[m][n] != -1) {
      return dp[m][n];
    }

    if (s1.charAt(m) == s2.charAt(n)) {
      dp[m][n] = 1 + topDown(dp, s1, s2, m - 1, n - 1);
      return dp[m][n];
    }
    dp[m][n] = Math.max(topDown(dp, s1, s2, m - 1, n), topDown(dp, s1, s2, m, n - 1));
    return dp[m][n];
  }

  public static void main(String[] args) {
    System.out.println(lcs("abcde", "ace"));
    System.out.println(solve("naman"));
  }
}
