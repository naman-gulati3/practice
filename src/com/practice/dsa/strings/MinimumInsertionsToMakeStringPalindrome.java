package com.practice.dsa.strings;

public class MinimumInsertionsToMakeStringPalindrome {

  public static int solve(String s) {
    StringBuilder sb = new StringBuilder(s);
    String reversed = sb.reverse().toString();

    int lcs = lcs(s, reversed);
    return s.length() - lcs;
  }


  // bottom up
  private static int lcs(String s1, String s2) {
    int n = s1.length();
    int m = s2.length();
    int[][] dp = new int[n + 1][m + 1];

    for (int i = n - 1; i >= 0; i--) {
      for (int j = m - 1; j >= 0; j--) {
        if (s1.charAt(i) == s2.charAt(j)) {
          // 1 + result from diagonal
          dp[i][j] = 1 + dp[i + 1][j + 1];
        } else {
          dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
        }
      }
    }
    return dp[0][0];
  }

  public static void main(String[] args) {
    System.out.println(lcs("abcde", "ace"));
    System.out.println(solve("naman"));
  }
}
