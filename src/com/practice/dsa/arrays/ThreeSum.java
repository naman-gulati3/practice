package com.practice.dsa.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

  public static List<List<Integer>> threeSum(int[] nums) {
    int n = nums.length;
    Arrays.sort(nums);
    Set<List<Integer>> result = new HashSet<>();
    for (int i = 0; i < n; i++) {
      int j = i + 1;
      int k = n - 1;

      while (j < k) {
        int sum = nums[i] + nums[j] + nums[k];
        if (sum == 0) {
          result.add(List.of(nums[i], nums[j], nums[k]));
          j++;
          k--;
        } else if (sum > 0) {
          k--;
        } else {
          j++;
        }
      }
    }
    return result.stream().toList();
  }

  public static void main(String[] args) {
    System.out.println(threeSum(new int[]{-2, 0, 1, 1, 2}));
  }

}
