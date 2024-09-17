package com.practice.dsa.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

  public static List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> result = new ArrayList<>();

    int left = 0;
    int top = 0;
    int right = matrix[0].length - 1;
    int bottom = matrix.length - 1;

    while (left <= right && top <= bottom) {
      // top row
      for (int i = left; i <= right; i++) {
        result.add(matrix[top][i]);
      }
      top++;
      // last col

      for (int i = top; i <= bottom; i++) {
        result.add(matrix[i][right]);
      }

      right--;
      // last row
      if (top <= bottom) {
        for (int i = right; i >= left; i--) {
          result.add(matrix[bottom][i]);
        }
        bottom--;
      }

      if (left <= right) {
        for (int i = bottom; i >= top; i--) {
          result.add(matrix[i][left]);
        }
        left++;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    // 1  2  3  4
    // 5  6  7  8
    // 9 10  11 12
    System.out.println(spiralOrder(new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
  }
}
