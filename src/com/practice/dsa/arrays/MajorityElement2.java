package com.practice.dsa.arrays;

public class MajorityElement2 {


  public static void main(String[] args) {
    System.out.println(majorityElement(new int[] {2, 2, 1, 3, 1, 1, 3, 1, 1}));
  }

  private static int majorityElement(int[] nums) {
    int count1 = 0;
    int count2 = 0;
    int candidate1 = Integer.MIN_VALUE;
    int candidate2 = Integer.MIN_VALUE;

    for(int num : nums) {
      if(count1 == 0 && candidate2 != num) {
        count1 = 1;
        candidate1 = num;
      } else if (count2 == 0 && candidate1 != num) {
        count2 = 1;
        candidate2 = num;
      } else if (num == candidate1) {
        count1++;
      } else if (num == candidate2) {
        count2++;
      } else {
        count1--;
        count2--;
      }
    }

    int cnt1 = 0;
    int cnt2 = 0;
    for(int num : nums) {
      if(num == candidate1) {
        cnt1++;
      }

      if(num == candidate2) {
        cnt2++;
      }
    }

    if(cnt1 >= (nums.length / 3)) {
      return candidate1;
    }

    if(cnt2 >= (nums.length / 3)) {
      return candidate2;
    }

    return -1;
  }
}
