package com.practice.dsa.dp;

import java.util.Arrays;

public class DecodeWays {

  public static int numDecodings(String s) {
    int[] dp = new int[s.length() + 1];
    Arrays.fill(dp, -1);

    return solve(s, dp, 0);
  }

  private static int solve(String s, int[] dp, int i) {
    if (i == s.length()) {
      return 1;
    }
    if (s.charAt(i) == '0') {
      return 0;
    }

    if (dp[i] != -1) {
      return dp[i];
    }

    int ans = solve(s, dp, i + 1);

    if (i + 1 < s.length()) {
      int twoDigits = Integer.parseInt(s.substring(i, i + 2));
      if (twoDigits >= 10 && twoDigits <= 26) {
        ans += solve(s, dp, i + 2);
      }
    }

    return dp[i] = ans;
  }

  public static void main(String[] args) {
    System.out.println(numDecodings("226"));
  }
}
