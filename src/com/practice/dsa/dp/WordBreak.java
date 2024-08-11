package com.practice.dsa.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

  public static boolean wordBreak(String s, List<String> wordDict) {
    Set<String> dict = new HashSet<>(wordDict);
    int[] dp = new int[s.length()];

    Arrays.fill(dp, -1);

    int result = topDown(s, 0, dict, dp);
    return result == 1;
  }

  private static int topDown(String s, int i, Set<String> dict, int[] dp) {
    if (i == s.length()) {
      return 1;
    }

    if (dp[i] != -1) {
      return dp[i];
    }

    StringBuilder sb = new StringBuilder();
    for (int j = i; j < s.length(); j++) {
      sb.append(s.charAt(j));

      if (dict.contains(sb.toString())) {
        if (topDown(s, j + 1, dict, dp) == 1) {
          dp[i] = 1;
          return dp[i];
        }
      }
    }
    dp[i] = 0;
    return dp[i];
  }

  public static void main(String[] args) {
//    System.out.println(wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat")));
    System.out.println(wordBreak("applepenapple", List.of("apple", "pen")));
  }
}
