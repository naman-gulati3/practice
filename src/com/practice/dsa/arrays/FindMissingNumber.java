package com.practice.dsa.arrays;

public class FindMissingNumber {

  public static int missingNumber(int[] nums) {
    int xor1 = 0;
    int xor2 = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      xor1 = xor1 ^ (i + 1);
      xor2 = xor2 ^ nums[i];
    }

    xor1 = xor1 ^ (nums.length - 1);
    return xor1 ^ xor2;
  }

  public static int missingNumber2(int[] nums) {
    int xor1 = 0;
    int xor2 = 0;
    // xor all numbers from 1 to n
    for (int i = 1; i <= nums.length; i++) {
      xor1 = xor1 ^ i;
    }

    // xor all numbers expect last one
    for (int i = 0; i < nums.length - 1; i++) {
      xor2 = xor2 ^ nums[i];
    }

    return xor1 ^ xor2;
  }

  public static void main(String[] args) {
    System.out.println(missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    System.out.println(missingNumber2(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
  }
}