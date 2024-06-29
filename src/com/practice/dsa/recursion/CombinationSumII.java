package com.practice.dsa.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

  public static void main(String[] args) {
    System.out.println(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
  }

  public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> result = new ArrayList<>();
    recurse2(candidates, result, new ArrayList<>(), target, 0);
    return result;
  }

  private static void recurse(int[] candidates, List<List<Integer>> result,
      ArrayList<Integer> currentNums, int target, int i) {
    if (i == candidates.length) {
      if (target == 0) {
        result.add(new ArrayList<>(currentNums));
      }
      return;
    }

    if (candidates[i] <= target && !currentNums.contains(candidates[i])) {
      currentNums.add(candidates[i]);
      recurse(candidates, result, currentNums, target - candidates[i], i + 1);
      currentNums.remove(currentNums.size() - 1);
    }
    recurse(candidates, result, currentNums, target, i + 1);
  }

  private static void recurse2(int[] candidates, List<List<Integer>> result,
      ArrayList<Integer> currentNums, int target, int i) {
    if (target == 0) {
      result.add(new ArrayList<>(currentNums));
    }

    for (int idx = i; idx < candidates.length; idx++) {
      if (idx > i && candidates[idx] == candidates[idx - 1]) {
        continue;
      }

      if (candidates[idx] > target) {
        break;
      }

      currentNums.add(candidates[idx]);
      recurse2(candidates, result, currentNums, target - candidates[idx], idx + 1);
      currentNums.remove(currentNums.size() - 1);
    }
  }
}
