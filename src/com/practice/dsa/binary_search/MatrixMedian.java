package com.practice.dsa.binary_search;

public class MatrixMedian {

  public static void main(String[] args) {
    System.out.println(median(new int[][]{{1, 3, 5},
        {2, 6, 9},
        {3, 6, 9}}, 3, 3));
  }

  // 1, 3, 5
  // 2, 6, 9
  // 3, 6, 9

  static int median(int[][] matrix, int R, int C) {
    int low = Integer.MAX_VALUE;
    int high = Integer.MIN_VALUE;

    // required for median
    int required = (R * C) / 2;

    for (int i = 0; i < R; i++) {
      // smallest element of each row will always be on first index since rows are sorted
      low = Math.min(low, matrix[i][0]);
      high = Math.max(high, matrix[i][C - 1]);
    }

    while (low <= high) {
      int mid = (low + high) / 2;
      // get how many element are smaller than or equal to mid
      int smallestEquals = getSmallestEquals(matrix, mid);

      if (smallestEquals <= required) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return low;
  }

  private static int getSmallestEquals(int[][] matrix, int mid) {
    int count = 0;
    for (int[] row : matrix) {
      count += upperBound(row, mid);
    }
    return count;
  }

  private static int upperBound(int[] row, int target) {
    int low = 0;
    int high = row.length - 1;
    int ans = row.length;

    while (low <= high) {
      int mid = (low + high) / 2;
      if (row[mid] > target) {
        ans = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return ans;
  }
}
