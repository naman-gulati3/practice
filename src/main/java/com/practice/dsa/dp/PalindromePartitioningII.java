package com.practice.dsa.dp;

import java.util.Arrays;

public class PalindromePartitioningII {

  static int palindromicPartition(String str) {
    int[] dp = new int[str.length() + 1];
    Arrays.fill(dp, -1);

    // -1 to remove the partition at the end for eg. for string "ABC"
    // partitions will look like "A|B|C|" remove this extra partition at the end
    return topDown(dp, str, 0, str.length()) - 1;
  }

  private static int topDown(int[] dp, String str, int i, int n) {
    if (i == n) {
      return 0;
    }

    if (dp[i] != -1) {
      return dp[i];
    }

    int minCost = Integer.MAX_VALUE;
    for (int j = i; j < n; j++) {
      if (isPalindrome(i, j, str)) {
        int cost = 1 + topDown(dp, str, j + 1, n);
        minCost = Math.min(minCost, cost);
        dp[i] = minCost;
      }
    }
    return dp[i];
  }

  private static boolean isPalindrome(int start, int end, String s) {
    while (start < end) {
      if (s.charAt(start) != s.charAt(end)) {
        return false;
      }
      start++;
      end--;
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(palindromicPartition("ababbbabbababa"));
  }
}
