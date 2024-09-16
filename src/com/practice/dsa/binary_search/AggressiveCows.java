package com.practice.dsa.binary_search;

import java.util.Arrays;

public class AggressiveCows {

  public static void main(String[] args) {
    int[] stalls = {0, 3, 4, 7, 10, 9};
    int k = 4;
    int ans = aggressiveCows(stalls, k);
    System.out.println("The maximum possible minimum distance is: " + ans);
  }

  public static int aggressiveCows(int[] stalls, int k) {
    int n = stalls.length;
    // 0, 3, 4, 7, 9, 10
    Arrays.sort(stalls);

    int low = 1;
    // given the constraint 2 <= k <= stalls.length
    // max possible distance b/w cows can be the distance between first and last stall
    int high = stalls[n - 1] - stalls[0];
    while (low <= high) {
      int mid = (low + high) / 2;
      if (canBePlaced(stalls, k, mid)) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return high;
  }

  private static boolean canBePlaced(int[] stalls, int numCows, int mid) {
    int n = stalls.length;
    int cntCows = 1;
    int lastSeen = stalls[0];

    for (int i = 0; i < n; i++) {
      if (stalls[i] - lastSeen >= mid) {
        cntCows++;
        lastSeen = stalls[i];
      }
    }
    return cntCows >= numCows;
  }
}
