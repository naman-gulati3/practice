package com.practice.dsa.arrays;

public class MajorityElement {

  public static void main(String[] args) {
    System.out.println(majorityElement(new int[] {2, 2, 2, 2, 3, 4, 4}));
  }

  private static int majorityElement(int[] nums) {
    int count = 0;
    int candidate = 0;
    for (int num : nums) {
      if (count == 0) {
        candidate = num;
      }

      if (candidate == num) {
        count++;
      } else {
        count--;
      }
    }
    return candidate;
  }
}
