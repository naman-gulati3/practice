package com.practice.dsa.arrays;

import java.util.Arrays;

public class MergeSortedArrays {

  public static void main(String[] args) {
    int[] arr = new int[]{1, 2, 3, 0, 0, 0};
    int[] nums2 = new int[]{2, 5, 6};
    // 1, 2, 2, 0, 0, 0
    // 3, 5, 6

//    int[] arr = new int[]{0};
//    int[] nums2 = new int[]{1};

    merge(arr, 3, nums2, 3);
    System.out.println(Arrays.toString(arr));
  }

  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m;
    for (int j = 0; j < n; j++) {
      nums1[i] = nums2[j];
      i++;
    }
    Arrays.sort(nums1);
  }
}
