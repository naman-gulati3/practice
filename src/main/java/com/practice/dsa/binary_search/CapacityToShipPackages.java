package com.practice.dsa.binary_search;

import java.util.Arrays;

public class CapacityToShipPackages {

  public static int shipWithinDays(int[] weights, int days) {
    int low = Arrays.stream(weights).max().getAsInt();
    int high = Arrays.stream(weights).sum();

    while (low <= high) {
      int mid = (low + high) / 2;
      if (canCarry(weights, mid, days)) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return low;
  }

  private static boolean canCarry(int[] weights, int mid, int days) {
    int count = 1;
    int sum = 0;
    for (int i = 0; i < weights.length; i++) {
      sum += weights[i];
      if (sum > mid) {
        sum = weights[i];
        count++;
      }
    }

    return count <= days;
  }

  public static void main(String[] args) {
    System.out.println(shipWithinDays(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
  }
}
