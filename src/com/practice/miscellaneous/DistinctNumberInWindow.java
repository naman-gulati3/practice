package com.practice.miscellaneous;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DistinctNumberInWindow {

  public static int[] dNums(int[] A, int B) {
    if (B == 1) {
      Arrays.fill(A, 1);
      return A;
    }

    Map<Integer, Integer> freqMap = new HashMap<>();
    int[] result = new int[A.length - B + 1];
    int distinctCount = 0;

    for (int i = 0; i < A.length; i++) {
      freqMap.put(A[i], freqMap.getOrDefault(A[i], 0) + 1);
      if (freqMap.get(A[i]) == 1) {
        distinctCount++;
      }

      if (i >= B) {
        int elementToRemove = A[i - B];
        freqMap.put(elementToRemove, freqMap.get(elementToRemove) - 1);
        if (freqMap.get(elementToRemove) == 0) {
          distinctCount--;
        }
      }

      if (i >= B - 1) {
        result[i - B + 1] = distinctCount;
      }

    }
    return result;
  }

  public static void main(String[] args) {
    // 6 3 => 4
    // 6 2 => 5
    System.out.println(Arrays.toString(dNums(new int[]{1, 2, 1, 3, 4, 3}, 3)));
  }
}
