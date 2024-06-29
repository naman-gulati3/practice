package com.practice.dsa.arrays;

public class RotateMatrix {

  public static void rotate(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
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

  // 1, 2, 3     1, 4, 7
  // 4, 5, 6 =>  2, 5, 8
  // 7, 8, 9     3, 6, 9

  // 0,0 => 0,0
  // 0,1 => 1,0
  // 0,2 => 2,0
  // 1,0 => 0,1
  // 1,1 => 1,1
  // 1,2 => 2,1
  // 2,0 => 0,2
  // 2,1 => 1,2
  // 2,2 => 2,2

  public static void main(String[] args) {
    rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
  }
}
