package com.practice.miscellaneous.sliding_window;

import java.util.HashSet;
import java.util.Set;

public class MaximumErasureValue {

  // https://leetcode.com/problems/maximum-erasure-value/description/
  public static int maximumUniqueSubarray(int[] nums) {
    Set<Integer> set = new HashSet<>();
    int sum = 0;
    int ans = 0;
    int j = 0;
    for (int i = 0; i < nums.length; i++) {
      while (set.contains(nums[i])) {
        set.remove(nums[j]);
        sum -= nums[j];
        j++;
      }

      set.add(nums[i]);
      sum += nums[i];
      ans = Math.max(ans, sum);
    }

    return ans;
  }

  public static void main(String[] args) {
    System.out.println(maximumUniqueSubarray(new int[]{4, 2, 4, 5, 6}));
  }
}
