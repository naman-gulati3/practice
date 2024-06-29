package com.practice.dsa.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

  public static void main(String[] args) {
    System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
  }

  public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();

    Arrays.sort(candidates);
    recurse(candidates, result, new ArrayList<>(), target, 0);
    return result;
  }

  private static void recurse(int[] candidates, List<List<Integer>> result,
      ArrayList<Integer> currentSubset, int remaining, int i) {
    if (remaining == 0) {
      result.add(new ArrayList<>(currentSubset));
    } else if (remaining > 0) {
      for (int idx = i; idx < candidates.length; idx++) {
        currentSubset.add(candidates[idx]);
        recurse(candidates, result, currentSubset, remaining - candidates[idx], idx);
        currentSubset.remove(currentSubset.size() - 1);
      }
    }
  }


  private static void recurse2(List<List<Integer>> result, List<Integer> currentNums,
      int[] candidates, int remaining, int current) {
    if (current == candidates.length) {
      if (remaining == 0) {
        result.add(new ArrayList<>(currentNums));
      }
      return;
    }

    if (candidates[current] <= remaining) {
      currentNums.add(candidates[current]);
      recurse2(result, currentNums, candidates, remaining - candidates[current], current);
      currentNums.remove(currentNums.size() - 1);
    }
    recurse2(result, currentNums, candidates, remaining, current + 1);
  }
}
