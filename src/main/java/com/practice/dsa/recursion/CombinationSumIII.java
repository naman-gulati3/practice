package com.practice.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

  public static List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> result = new ArrayList<>();
    recurse(result, n, k, 1, new ArrayList<>());

    return result;
  }

  private static void recurse(List<List<Integer>> result, int n, int k, int i,
      ArrayList<Integer> currentRes) {
    if (k == 0 && n == 0) {
      result.add(new ArrayList<>(currentRes));
      return;
    }

    if (k == 0 || n < 0) {
      return;
    }

    for (int idx = i; idx <= 9 && idx <= n; idx++) {
      currentRes.add(idx);
      recurse(result, n - idx, k - 1, idx + 1, currentRes);
      currentRes.remove(currentRes.size() - 1);
    }
  }

  public static void main(String[] args) {
    System.out.println(combinationSum3(3, 7));
  }

}
