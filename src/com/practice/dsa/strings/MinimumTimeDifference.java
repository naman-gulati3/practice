package com.practice.dsa.strings;

import java.util.Arrays;
import java.util.List;

public class MinimumTimeDifference {

  record Pair(int hour, int minute) {

  }

  public static int findMinDifference(List<String> timePoints) {
    int[] mins = new int[timePoints.size()];
    int minimum = Integer.MAX_VALUE;
    for (int i = 0; i < timePoints.size(); i++) {
      String[] split = timePoints.get(i).split(":");
      int min = Integer.parseInt(split[1]);
      int hour = Integer.parseInt(split[0]);

      mins[i] = hour * 60 + min;
    }

    Arrays.sort(mins);
    for (int i = 0; i < mins.length - 1; i++) {
      minimum = Math.min(minimum, mins[i + 1] - mins[i]);
    }
    return Math.min(minimum, 1440 - mins[mins.length - 1] + mins[0]);
  }

  public static void main(String[] args) {
    System.out.println(findMinDifference(List.of("23:59", "00:00"))); // 1
    System.out.println(findMinDifference(List.of("00:00", "23:59", "00:00"))); // 0
    System.out.println(findMinDifference(List.of("01:01", "02:01"))); // 60
    System.out.println(findMinDifference(List.of("02:42", "03:21"))); // 39
    System.out.println(findMinDifference(List.of("02:21", "03:42"))); // 81
  }
}
