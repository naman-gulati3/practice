package com.practice.dsa.arrays;

import java.util.Arrays;

public class LongestConsectiveSequence {

  public static void main(String[] args) {
    // 0, 0, 1, 2, 3, 4, 5, 6, 7, 8
    System.out.println(longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
  }

  public static int longestConsecutive(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }

    int lastSeenSmallest;
    Arrays.sort(nums);
    int currentSequenceLength = 1;
    int longestSequence = 1;
    for (int i = 1; i < nums.length; i++) {
      lastSeenSmallest = nums[i - 1];
      if (nums[i] - lastSeenSmallest == 1) {
        currentSequenceLength++;
        longestSequence = Math.max(currentSequenceLength, longestSequence);
      } else if (nums[i] - lastSeenSmallest > 1) {
        currentSequenceLength = 1;
      }
    }
    return longestSequence;
  }
}
