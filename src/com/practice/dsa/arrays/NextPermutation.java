package com.practice.dsa.arrays;

import java.util.Arrays;

public class NextPermutation {
  // https://leetcode.com/problems/next-permutation/description/

  //  eg 1:   1, 3, 5, 2 -> 1, 5, 2, 3
  // eg 2:    1, 2, 3, 5 -> 1, 2, 5, 3
  // eg 3:    1, 3, 2 -> 2, 1, 3

  public static void main(String[] args) {
    int[] nums = new int[]{1, 2, 3};
    nextPermutation(nums);
    System.out.println(Arrays.toString(nums));
  }

  public static void nextPermutation(int[] nums) {
    int breakPoint = -1;
    int n = nums.length;

    for(int i = n - 2; i >= 0; i--) {
      if(nums[i] < nums[i + 1]) {
        breakPoint = i;
        break;
      }
    }

    if(breakPoint == -1) {
      reverseArr(nums, 0, n - 1);
      return;
    }

    for(int i = n - 1; i > breakPoint; i--) {
      if(nums[i] > nums[breakPoint]) {
        swap(nums, breakPoint, i);
        break;
      }
    }

    reverseArr(nums, breakPoint + 1, n - 1);
  }

  private static void reverseArr(int[] nums, int i, int n) {
    while(i < n) {
      swap(nums, i, n);
      i++;
      n--;
    }
  }

  private static void swap(int[] nums, int i, int n) {
    int temp = nums[i];
    nums[i] = nums[n];
    nums[n] = temp;
  }
}
