package com.practice.dsa.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

  public static List<List<Integer>> threeSum(int[] nums) {
    int n = nums.length;
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
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

        while (nums[j] == nums[j - 1] && j < k) {
          j++;
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(threeSum(new int[] {-2, 0, 0, 2, 2}));
  }
}
