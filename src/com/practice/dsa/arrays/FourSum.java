package com.practice.dsa.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {

  public static void main(String[] args) {
    System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    System.out.println(fourSumOptimal(new int[]{1, 0, -1, 0, -2, 2}, 0));
    // 1,0,-1,0,-2,2
    // 1,1,0,0,-2,0
    // 1,0,-1,0,0,2
  }

  public static List<List<Integer>> fourSum(int[] nums, int target) {
    Set<List<Integer>> result = new HashSet<>();

    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        Set<Integer> remaining = new HashSet<>();
        for (int k = j + 1; k < nums.length; k++) {
          int sum = nums[i] + nums[j];
          sum += nums[k];
          int fourth = target - sum;
          if (remaining.contains(fourth)) {
            List<Integer> sol = new ArrayList<>(List.of(nums[i], nums[j], nums[k], fourth));
            sol.sort(Comparator.comparingInt(num -> num));
            result.add(sol);
          }
          remaining.add(nums[k]);
        }
      }
    }
    return result.stream().toList();
  }

  public static List<List<Integer>> fourSumOptimal(int[] nums, int target) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);

    for (int i = 0; i < nums.length; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      for (int j = i + 1; j < nums.length; j++) {
        if (j != i + 1 && nums[j] == nums[j - 1]) {
          continue;
        }

        int k = j + 1;
        int l = nums.length - 1;
        while (k < l) {
          int sum = nums[i] + nums[j] + nums[k] + nums[l];
          if (sum == target) {
            List<Integer> sol = new ArrayList<>(List.of(nums[i], nums[j], nums[k], nums[l]));
            result.add(sol);
          }

          if (sum > target) {
            l--;
          } else {
            k++;
          }
        }
      }
    }
    return result;
  }
}
