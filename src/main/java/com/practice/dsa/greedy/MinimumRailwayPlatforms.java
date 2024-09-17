package com.practice.dsa.greedy;

import java.util.Arrays;

public class MinimumRailwayPlatforms {

  static int findPlatform(int[] arr, int[] dep, int n) {
    Arrays.sort(arr);
    Arrays.sort(dep);

    int maxPlatforms = 1;
    int currentMax = 1;
    int i = 1, j = 0;

    while (i < n && j < n) {
      if (arr[i] <= dep[j]) {
        System.out.printf("arr: %s, dep: %s\n", arr[i], dep[j]);
        currentMax++;
        i++;
      } else if (arr[i] > dep[j]) {
        currentMax--;
        j++;
      }

      if (currentMax > maxPlatforms) {
        maxPlatforms = currentMax;
      }
    }
    return maxPlatforms;
  }

  public static void main(String[] args) {
    // 900, 940,  950,  1100, 1500, 1800
    // 910, 1120, 1130, 1200, 1900, 2000

    System.out.println(
        findPlatform(
            new int[] {900, 940, 950, 1100, 1500, 1800},
            new int[] {910, 1200, 1120, 1130, 1900, 2000},
            6));
  }
}
