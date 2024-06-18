package com.practice.dsa.arrays;

public class DuplicateNumber {

  public static int findDuplicate(int[] nums) {
    int dup = -1;
    for(int i = 0; i < nums.length - 1; i++) {
      dup = nums[i] ^ nums[i + 1];
    }
    return dup;
  }

  public static void main(String[] args) {
    System.out.println(findDuplicate(new int[]{1,3,4,2,2}));
  }
}
