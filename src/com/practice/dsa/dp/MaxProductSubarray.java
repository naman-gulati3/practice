package com.practice.dsa.dp;

public class MaxProductSubarray {

  public static int maxProduct(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }

    int n = nums.length;
    double prefix = 1;
    double suffix = 1;
    double max = Integer.MIN_VALUE;

    for (int i = 0; i < n; i++) {
      if (prefix == 0) {
        prefix = 1;
      }

      if (suffix == 0) {
        suffix = 1;
      }

      prefix = prefix * nums[i];
      suffix = suffix * nums[n - 1 - i];

      max = Math.max(max, Math.max(prefix, suffix));
    }
    return (int) max;
  }

  public static void main(String[] args) {
    System.out.println(maxProduct(new int[]{-2, 0, -1})); // 60
  }
}
