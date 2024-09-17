package com.practice.dsa.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubSetII {

  public static void main(String[] args) {
    System.out.println(subsetsWithDup(new int[] {4, 4, 4, 1, 4}));
  }

  public static List<List<Integer>> subsetsWithDup(int[] nums) {
    Set<List<Integer>> result = new HashSet<>();
    Arrays.sort(nums);
    recurse(nums, result, new ArrayList<>(), 0);
    return result.stream().toList();
  }

  private static void recurse(
      int[] nums, Set<List<Integer>> result, List<Integer> currentSubset, int i) {
    if (i == nums.length) {
      result.add(new ArrayList<>(currentSubset));
      return;
    }

    currentSubset.add(nums[i]);
    recurse(nums, result, currentSubset, i + 1);
    currentSubset.remove(currentSubset.size() - 1);
    recurse(nums, result, currentSubset, i + 1);
  }
}
