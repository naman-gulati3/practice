package com.practice.dsa.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniquePermutations {

  public static void main(String[] args) {
    System.out.println(permuteUnique(new int[] {1, 1, 2}));
  }

  public static List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    boolean[] used = new boolean[nums.length];

    recurse(result, nums, used, new ArrayList<>());
    return result;
  }

  private static void recurse(
      List<List<Integer>> result, int[] nums, boolean[] used, ArrayList<Integer> currentSet) {
    if (currentSet.size() == nums.length) {
      result.add(new ArrayList<>(currentSet));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
        continue;
      }

      used[i] = true;
      currentSet.add(nums[i]);
      recurse(result, nums, used, currentSet);
      currentSet.remove(currentSet.size() - 1);
      used[i] = false;
    }
  }
}
