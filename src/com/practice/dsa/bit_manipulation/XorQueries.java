package com.practice.dsa.bit_manipulation;

import java.util.Arrays;

public class XorQueries {


  public static int[] xorQueries(int[] arr, int[][] queries) {
    int[] result = new int[queries.length];

    for (int i = 0; i < queries.length; i++) {
      // find i'th query [0, 1]
      int[] query = queries[i];

      // xor = arr[0] i.e 1;
      int xor = 0;
      for (int j = query[0]; j <= query[1]; j++) {
        xor ^= arr[j];
      }
      result[i] = xor;
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(
        Arrays.toString(
            xorQueries(new int[]{16}, new int[][]{{0, 0}, {0, 0}, {0, 0}})));
  }
}
