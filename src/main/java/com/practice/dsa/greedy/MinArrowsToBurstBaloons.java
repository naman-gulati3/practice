package com.practice.dsa.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MinArrowsToBurstBaloons {

  public static int findMinArrowShots(int[][] points) {
    Arrays.sort(points, Comparator.comparingInt(o -> o[1]));

    int arrows = 1;
    int end = points[0][1];

    for (int i = 1; i < points.length; i++) {
      // this means interval is un-mergable
      if (points[i][0] > end) {
        arrows++;
        end = points[i][1];
      }
    }
    return arrows;
  }

  // 1------------6
  //   2-------------------8
  //                  7----------------12
  //                            10---------------16

  // [1, 6], [2, 8], [7, 12], [10, 16]
  // end = 6
  // 2 > 6 false
  // i = 2
  // 7 > 6 true
  // arrows = 2, end = 12
  // i = 3
  // 10 < 12
  // done
  public static void main(String[] args) {
    System.out.println(findMinArrowShots(new int[][] {{10, 16}, {2, 8}, {1, 6}, {7, 12}}));
  }
}
