package com.practice.dsa.recursion;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SubsetSum {

  static List<Integer> subsetSums(List<Integer> arr, int n) {
    List<Integer> result = new ArrayList<>();
    recurse(0, 0, result, arr);
    result.sort(Comparator.comparingInt(i -> i));
    return result;
  }

  static void recurse(int currentSum, int index, List<Integer> result, List<Integer> arr) {
    if (index == arr.size()) {
      result.add(currentSum);
      return;
    }

    // pick element
    recurse(currentSum + arr.get(index), index + 1, result, arr);

    // dont pick element
    recurse(currentSum, index + 1, result, arr);
  }

  public static void main(String[] args) {
    System.out.println(subsetSums(List.of(5, 2, 1), 3));
  }
}
