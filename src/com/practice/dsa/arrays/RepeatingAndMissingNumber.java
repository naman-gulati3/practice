package com.practice.dsa.arrays;

import java.util.Arrays;

public class RepeatingAndMissingNumber {

  public static int[] repeatedNumber(final int[] arr) {
    int[] result = new int[2];
    for (int i = 0; i < arr.length; i++) {
      while (arr[i] != i + 1) {
        int correctPosition = arr[i] - 1;
        if (arr[i] == arr[correctPosition]) {
          break;
        }
        int temp = arr[i];
        arr[i] = arr[correctPosition];
        arr[correctPosition] = temp;
      }
    }

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != i + 1) {
        result[1] = i + 1;
        result[0] = arr[i];
        break;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    // 1, 2, 3, 1, 5
    System.out.println(Arrays.toString(repeatedNumber(
        new int[]{3, 1, 2, 5, 3})));
  }
}
