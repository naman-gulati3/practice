package com.practice.dsa.arrays;

public class DuplicateNumber {

  public static int findDuplicate(int[] nums) {
    int fast = nums[0];
    int slow = nums[0];

    do {
      slow = nums[slow];
      fast = nums[nums[fast]];
    } while (slow != fast);

    int slow2 = nums[0];
    while (slow != slow2) {
      slow = nums[slow];
      slow2 = nums[slow2];
    }
    return slow;
  }

  public static void main(String[] args) {
    System.out.println(findDuplicate(new int[]{2, 5, 9, 6, 9, 3, 8, 9, 7, 1}));
  }
}
