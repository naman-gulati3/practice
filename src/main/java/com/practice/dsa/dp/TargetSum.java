package com.practice.dsa.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TargetSum {

  public static int findTargetSumWays(int[] nums, int target) {
    int n = nums.length;
    int total = Arrays.stream(nums).sum();

    if (target > total || target < -total) {
      return 0;
    }

    Map<Integer, Map<Integer, Integer>> dp = new HashMap<>();
    return topDown(nums, n - 1, target, dp);
  }

  private static int topDown(
      int[] nums, int n, int target, Map<Integer, Map<Integer, Integer>> dp) {
    if (n == 0) {
      int ways = 0;
      if (target - nums[n] == 0) {
        ways++;
      }

      if (target + nums[n] == 0) {
        ways++;
      }
      return ways;
    }

    if (dp.containsKey(n)) {
      if (dp.get(n).containsKey(target)) {
        return dp.get(n).get(target);
      }
    }
    int sum = topDown(nums, n - 1, target + nums[n], dp);

    int diff = topDown(nums, n - 1, target - nums[n], dp);

    int totalWays = sum + diff;

    Map<Integer, Integer> cache = new HashMap<>();
    cache.put(target, totalWays);
    dp.put(n, cache);
    return dp.get(n).get(target);
  }

  public static void main(String[] args) {
    System.out.println(findTargetSumWays(new int[] {1, 2, 1}, 0));
    // -1 - 1 + 2
    // +1 + 1 - 2
    System.out.println(findTargetSumWays(new int[] {7, 9, 3, 8, 0, 2, 4, 8, 3, 9}, 0));
  }
}
// 1 + 1 - 1 - 1 + 1
// 1 - 1 + 1 + 1 - 1
// 1 + 1 + 1 - 1 - 1
// 1 + 1 - 1 + 1 - 1

//   0 1 2 3
// 0 0 0 0 0
// 1 0 5
// 2 0
// 3 0
// 4 0
