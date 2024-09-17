package com.practice.dsa.dp;

import java.util.Arrays;

public class EditDistance {

  public static int minDistance(String word1, String word2) {
    int n = word1.length();
    int m = word2.length();

    int[][] dp = new int[n + 1][m + 1];
    for (int[] rows : dp) {
      Arrays.fill(rows, -1);
    }

    return solve(word1, n - 1, word2, m - 1, dp);
  }

  public static int mindDistanceTabulation(String word1, String word2) {
    int n = word1.length();
    int m = word2.length();

    int[][] dp = new int[n + 1][m + 1];
    for (int i = 0; i <= n; i++) {
      dp[i][0] = i;
    }

    for (int j = 0; j <= m; j++) {
      dp[0][j] = j;
    }
    //   r o s
    // h 0 0 0 0
    // o 0
    // r 0
    // s 0
    // e 0
    //   0

    //     r  o  s
    // h   0, 1, 2, 3,
    // o   1, 0, 0, 0
    // r   2, 0, 0, 0
    // s   3, 0, 0, 0
    // e   4, 0, 0, 0
    //     5, 0, 0, 0

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
        }
      }
    }
    return dp[n][m];
  }

  private static int solve(String word1, int i, String word2, int j, int[][] dp) {
    if (i == 0) {
      // word1 is exhausted. Return j so that we can insert characters from word2
      return j;
    }

    if (j == 0) {
      // word2 is exhausted. Return i so that we can delete characters from word1 to make string
      // match
      return i;
    }

    if (dp[i][j] != -1) {
      return dp[i][j];
    }

    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
      dp[i][j] = solve(word1, i - 1, word2, j - 1, dp);
      return dp[i][j];
    }
    // dp[i - 1][j] means deletion, we are moving the cursor back without touching string word2
    // dp[i][j - 1] means insertion, we took a character from word2, i stays where it was in word1
    // and j moves to left in word2
    // dp[i - 1][j - 1] means replace
    dp[i][j] =
        1
            + Math.min(
                solve(word1, i - 1, word2, j, dp),
                Math.min(solve(word1, i, word2, j - 1, dp), solve(word1, i - 1, word2, j - 1, dp)));
    return dp[i][j];
  }

  public static void main(String[] args) {
    System.out.println(minDistance("horse", "ros"));
    System.out.println(mindDistanceTabulation("horse", "ros"));
  }
}
