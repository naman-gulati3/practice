package com.practice.dsa.arrays;

import java.util.Arrays;

public class RotateMatrix {

  public static void rotate(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      // 0,1 => 2
      // 0,2 => 3

      // 1,2

      for (int j = i + 1; j < matrix[0].length; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }

    for (int i = 0; i < matrix.length; i++) {
      int j = 0;
      int k = matrix.length - 1;

      while (j < k) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[i][k];
        matrix[i][k] = temp;
        j++;
        k--;
      }
    }
  }

  // after transposition
  // 1, 2, 3     1, 4, 7
  // 4, 5, 6 =>  2, 5, 8
  // 7, 8, 9     3, 6, 9

  // 0,0 => 0,0 not required
  // 0,1 => 1,0
  // 0,2 => 2,0
  // 1,0 => 0,1 not required (done above already)
  // 1,1 => 1,1 not required
  // 1,2 => 2,1
  // 2,0 => 0,2 not required (done above already)
  // 2,1 => 1,2 not required (done above already)
  // 2,2 => 2,2 not required

  // after rotation
  // 1,2,3    7,4,1
  // 4,5,6 => 8,5,2
  // 7,8,9    9,6,3

  public static void main(String[] args) {
    int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    rotate(arr);
    System.out.println(Arrays.deepToString(arr));
  }
}
