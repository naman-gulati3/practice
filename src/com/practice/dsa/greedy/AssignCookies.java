package com.practice.dsa.greedy;

import java.util.Arrays;

public class AssignCookies {

  public static int findContentChildren(int[] greed, int[] size) {
    Arrays.sort(greed);
    Arrays.sort(size);

    int j = 0;
    int i = 0;

    while (i < size.length && j < greed.length) {
      if (size[i] >= greed[j]) {
        j++;
      }
      i++;
    }
    // g =  [1, 2]
    // [1, 2, 3]

    // g = [1, 2, 3]
    // [1, 1]

    // g = [1, 2, 3]
    // s = [3]

    return j;
  }

  public static void main(String[] args) {
    System.out.println(findContentChildren(new int[]{1, 2, 3}, new int[]{3}));
  }
}
