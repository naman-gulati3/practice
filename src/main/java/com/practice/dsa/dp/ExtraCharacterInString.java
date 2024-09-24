package com.practice.dsa.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ExtraCharacterInString {

  public static void main(String[] args) {
    System.out.println(minExtraChar("leetscode", new String[]{"leet", "code", "leetcode"}));
  }

  public static int minExtraChar(String s, String[] dictionary) {
    Set<String> words = new HashSet<>(Arrays.stream(dictionary).toList());

    int[] dp = new int[s.length() + 1];
    Arrays.fill(dp, -1);

    return solve(s, words, 0, s.length(), dp);
  }

  private static int solve(String s, Set<String> words, int i, int n, int[] dp) {
    if (i == n) {
      return 0;
    }

    if (dp[i] != -1) {
      return dp[i];
    }

    dp[i] = n - i;

    StringBuilder sb = new StringBuilder();
    for (int j = i; j < n; j++) {
      sb.append(s.charAt(j));

      if (words.contains(sb.toString())) {
        dp[i] = Math.min(dp[i], solve(s, words, j + 1, n, dp));
      }
    }

    dp[i] = Math.min(dp[i], 1 + solve(s, words, i + 1, n, dp));
    return dp[i];
  }
}
