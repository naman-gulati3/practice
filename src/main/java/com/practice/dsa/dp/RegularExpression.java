package com.practice.dsa.dp;

import java.util.Arrays;

public class RegularExpression {

  public static boolean isMatch(String s, String p) {
    int m = s.length();
    int n = p.length();
    int[][] dp = new int[m + 1][n + 1];
    for (int[] row : dp) {
      Arrays.fill(row, -1);
    }
    return match(m - 1, n - 1, s, p, dp);
  }

  private static boolean match(int i, int j, String s, String p, int[][] dp) {
    if (i < 0 && j < 0) {
      return true;
    }

    if (j < 0) {
      return false;
    }

    if (i < 0) {
      for (int num = 0; num <= j; num++) {
        if (p.charAt(num) != '*') {
          return false;
        }
      }

      return true;
    }

    if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
      boolean res = match(i - 1, j - 1, s, p, dp);
      // dp[i][j] = res ? 1 : 0;
      // return dp[i][j] == 1;
      return res;
    }

    if (p.charAt(j) == '*') {
      return match(i - 1, j, s, p, dp) || match(i, j - 1, s, p, dp);
    }

    return false;
  }

  public static void main(String[] args) {
    System.out.println(isMatch("aab", "c*a*b"));
  }
}
