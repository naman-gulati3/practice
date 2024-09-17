package com.practice.dsa.arrays;

import java.util.HashMap;
import java.util.Map;

public class LargestSubarrayWithKSum {

  public static void main(String[] args) {
    //    System.out.println(maxLen(new int[]{15, -2, 2, -8, 1, 7, 10, 23}, 8, 0));
    System.out.println(maxLenBetter(new int[] {2, 0, 0, 0, 3}, 5, 3));
  }

  private static int maxLen(int[] arr, int n, int k) {
    int longestArrLength = 0;
    for (int i = 0; i < n; i++) {
      int sum = arr[i];
      for (int j = i; j < n; j++) {
        if (i != j) {
          sum = sum + arr[j];
        }
        if (sum == k) {
          longestArrLength = Math.max(longestArrLength, j - i + 1);
        }
      }
    }
    return longestArrLength;
  }

  private static int maxLenBetter(int[] arr, int n, int k) {
    int longestArrLength = 0;
    int currentSum = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      currentSum += arr[i];
      if (currentSum == k) {
        longestArrLength = Math.max(longestArrLength, i + 1);
      }
      int required = currentSum - k;
      if (map.containsKey(required)) {
        int len = i - map.get(required);
        longestArrLength = Math.max(longestArrLength, len);
      } else {
        if (!map.containsKey(currentSum)) {
          map.put(currentSum, i);
        }
      }
    }
    return longestArrLength;
  }
}
