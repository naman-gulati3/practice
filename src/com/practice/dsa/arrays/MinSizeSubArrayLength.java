package com.practice.dsa.arrays;

public class MinSizeSubArrayLength {

  public static int minSubArrayLen(int target, int[] nums) {
    int min = Integer.MAX_VALUE;

    int l = 0;
    int r = 0;
    int windowSum = 0;

    while (l <= r && r < nums.length) {
      if (windowSum + nums[r] >= target) {
        min = Math.min(min, r - l + 1);
        windowSum -= nums[l];
        l++;
        continue;
      }
      windowSum += nums[r];
      r++;
    }

    return min == Integer.MAX_VALUE ? 0 : min;
  }

  public static void main(String[] args) {
    System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
  }
}
