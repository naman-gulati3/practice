package com.practice.dsa.arrays;

import java.util.Arrays;

public class MergeSortedArrays {

  public static void main(String[] args) {
//    int[] arr = new int[]{1, 2, 3, 0, 0, 0};
//    int[] arr2 = new int[]{2, 5, 6};

    int[] arr = new int[]{0};
    int[] arr2 = new int[]{1};

    merge(arr, 0, arr2, 1);
    System.out.println(Arrays.toString(arr));
    System.out.println(Arrays.toString(arr2));
  }

  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    int left = 0;
    int right = 0;

    while (left < nums1.length && right < nums2.length) {
      if (nums1[left] <= nums2[right]) {
        left++;
      } else {
        int temp = nums1[left];
        nums1[left] = nums2[right];
        nums2[right] = temp;
        right++;
      }
    }

    for (int i = m; i < nums1.length; i++) {
      nums1[i] = nums2[i - n];
    }
  }
}
