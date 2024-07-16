package com.practice.dsa.binary_search;

public class KthElementOfTwoSortedArrays {

  public static void main(String[] args) {
    // 1, 2, 3, 4, 6, 7, 8, 9, 10
    System.out.println(kthElement(new int[]{2, 3, 6, 7, 9}, new int[]{1, 4, 8, 10}, 5, 4, 5));
  }

  public static long kthElement(int[] arr1, int[] arr2, int n, int m, int k) {
    int ele = -1;
    int count = 0;

    int i = 0;
    int j = 0;
    while (i < n && j < m) {
      if (arr1[i] < arr2[j]) {
        if (count == k - 1) {
          ele = arr1[i];
        }
        count++;
        i++;
      } else {
        if (count == k - 1) {
          ele = arr2[j];
        }
        count++;
        j++;
      }
    }

    while (i < n) {
      if (count == k - 1) {
        ele = arr1[i];
      }
      count++;
      i++;
    }

    while (j < m) {
      if (count == k - 1) {
        ele = arr2[j];
      }
      count++;
      j++;
    }

    return ele;
  }
}
