package com.practice.dsa.arrays;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubArrayWithSumK {

  public static int subarraySum(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    int sum = 0;
    int count = 0;

    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];

      int remaining = sum - k;
      if (map.containsKey(remaining)) {
        count += map.get(remaining);
      }
      map.put(sum, map.getOrDefault(sum, 0) + 1);
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(subarraySum(new int[]{1, 2, 3}, 3));
  }
}
