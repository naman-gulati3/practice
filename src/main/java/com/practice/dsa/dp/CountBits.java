package com.practice.dsa.dp;

import java.util.Arrays;

public class CountBits {

  public static int[] countBits(int n) {
    int[] result = new int[n + 1];
    int offset = 1;
    for (int i = 1; i <= n; i++) {
      // if number is power of 2, update offset
      if (offset * 2 == i) {
        offset = i;
      }
      result[i] = 1 + result[i - offset];
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(countBits(4)));
  }
}
