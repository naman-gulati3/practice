package com.practice.dsa.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(twoSum(new int[] {3, 2, 4}, 5)));
  }

  public static int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      int diff = target - nums[i];
      if (map.containsKey(diff)) {
        return new int[] {i, map.get(diff)};
      } else {
        map.put(nums[i], i);
      }
    }
    return new int[] {};
  }
}
