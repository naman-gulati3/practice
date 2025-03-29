package com.practice.dsa.dp;

import java.util.Arrays;

public class InterleavingString {

  public static void main(String[] args) {
    System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
  }

  private static boolean isInterleave(String s1, String s2, String s3) {
    if (s1.length() + s2.length() != s3.length()) {
      return false;
    }

    int[][] dp = new int[s1.length() + 1][s2.length() + 1];
    for (int[] row : dp) {
      Arrays.fill(row, -1);
    }

    return solve(s1, s2, s3, 0, 0, dp);
  }

  private static boolean solve(String s1, String s2, String s3, int i, int j, int[][] dp) {
    int k = i + j;
    if (k == s3.length()) {
      return true;
    }

    if (dp[i][j] != -1) {
      return dp[i][j] == 1;
    }

    boolean canInterleave = false;
    if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
      canInterleave = solve(s1, s2, s3, i + 1, j, dp);
    }

    if (!canInterleave && j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
      canInterleave = solve(s1, s2, s3, i, j + 1, dp);
    }

    dp[i][j] = canInterleave ? 1 : 0;

    return canInterleave;
  }
}
