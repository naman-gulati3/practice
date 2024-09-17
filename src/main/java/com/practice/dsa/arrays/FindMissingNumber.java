package com.practice.dsa.arrays;

import java.util.Arrays;

public class FindMissingNumber {

  public static int missingNumber(int[] nums) {
    int xor1 = 0;
    int xor2 = 0;
    for (int i = 0; i < nums.length; i++) {
      xor1 = xor1 ^ (i + 1);
      xor2 = xor2 ^ nums[i];
    }

    return xor1 ^ xor2;
  }

  public static int missingNumber2(int[] nums) {
    int n = nums.length;
    int arrSum = Arrays.stream(nums).sum();
    int expectedSum = (n * (n + 1)) / 2;

    return expectedSum - arrSum;
    // sum = (n * (n+ 1)) / 2;
  }

  public static void main(String[] args) {
    System.out.println(missingNumber(new int[] {9, 6, 4, 2, 3, 5, 7, 0, 1}));
    System.out.println(missingNumber2(new int[] {9, 6, 4, 2, 3, 5, 7, 0, 1}));
  }
}
