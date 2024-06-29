package com.practice.dsa.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

  public static void main(String[] args) {
    System.out.println(permute(new int[]{1, 2, 3}));
  }

  public static List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);

    recurse(result, new ArrayList<>(), nums);
    return result;
  }

  private static void recurse(List<List<Integer>> result, List<Integer> currentPerm, int[] nums) {
    if (currentPerm.size() == nums.length) {
      result.add(new ArrayList<>(currentPerm));
      return;
    }

    for (int num : nums) {
      if (currentPerm.contains(num)) {
        continue;
      }
      currentPerm.add(num);
      recurse(result, currentPerm, nums);
      currentPerm.remove(currentPerm.size() - 1);
    }
  }
}
