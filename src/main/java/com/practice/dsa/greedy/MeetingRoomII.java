package com.practice.dsa.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoomII {


  public static int minRooms(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

    int i = 0;
    int j = 1;

    int count = 0;
    int max = 0;
    while (i < intervals.length && j < intervals.length) {
      if (intervals[i][0] > intervals[j][1]) {
        count++;
        i++;
      } else {
        count--;
        j++;
      }

      max = Math.max(max, count);
    }

    return max;
    // 0100 0500 0300 0400 0600
    // 0300 0800 0500 0800 0950

    // 0100 0300 0400 0500 0600
    // 0300 0500 0800 0800 0950

  }

  public static void main(String[] args) {
    //1600 1605 1610 1610
    // 1610 1610 1615 1625
    System.out.println(
        minRooms(new int[][]{{1600, 1610}, {1605, 1610}, {1610, 1615}, {1610, 1625}}));
  }
}