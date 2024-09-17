package com.practice.dsa.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeOverlappingInterval {

  public static int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
    List<int[]> merged = new ArrayList<>();
    int[] prev = intervals[0];

    for (int i = 1; i < intervals.length; i++) {
      int[] interval = intervals[i];
      if (interval[0] <= prev[1]) {
        prev[1] = Math.max(prev[1], interval[1]);
      } else {
        merged.add(prev);
        prev = interval;
      }
    }
    merged.add(prev);
    return merged.toArray(new int[merged.size()][]);
  }

  public static void main(String[] args) {
    System.out.println(Arrays.deepToString(merge(new int[][] {{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
  }
}
