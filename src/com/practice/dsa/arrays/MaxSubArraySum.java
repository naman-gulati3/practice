package com.practice.dsa.arrays;

public class MaxSubArraySum {

  public static int maxSubArray(int[] nums) {
    int max = Integer.MIN_VALUE;
    int sum = 0;
//    int start = 0;
//    int ansStart = -1;
//    int ansEnd = -1;

    for (int i = 0; i < nums.length; i++) {
//      if (sum == 0) {
//        start = i;
//      }

      sum += nums[i];
      if (sum > max) {
//        ansStart = start;
//        ansEnd = i;
        max = sum;
      }

      if (sum < 0) {
//        start = i;
        sum = 0;
      }
    }
    return max;
  }

  public static void main(String[] args) {
    // https://leetcode.com/problems/maximum-subarray/description/
    System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    System.out.println(maxSubArraySumRev(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    // 6
  }

  private static int maxSubArraySumRev(int[] nums) {
    int sum = 0;
    int maxSum = Integer.MIN_VALUE;

    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if (sum > maxSum) {
        maxSum = sum;
      }

      if (sum < 0) {
        sum = 0;
      }
      maxSum = Math.max(sum, maxSum);
    }
    return maxSum;
  }
}
