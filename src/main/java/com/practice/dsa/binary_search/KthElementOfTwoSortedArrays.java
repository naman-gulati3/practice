package com.practice.dsa.binary_search;

public class KthElementOfTwoSortedArrays {

  public static void main(String[] args) {
    // 1, 2, 3, 4, 6, 7, 8, 9, 10
    System.out.println(kthElement(new int[] {2, 3, 6, 7, 9}, new int[] {1, 4, 8, 10}, 5, 4, 5));
    System.out.println(
        kthElementOptimal(
            new int[] {76, 94, 100}, new int[] {5, 5, 9, 11, 31, 36, 68, 71, 75, 100}, 3, 10, 12));
  }

  public static long kthElementOptimal(int[] arr1, int[] arr2, int n, int m, int k) {

    if (n > m) {
      return kthElementOptimal(arr2, arr1, m, n, k);
    }

    // we want k elements on the left on sorted half to find kth element

    // 1, 4 | 8, 10
    //    l1 mid1
    //        r1

    // 2, 3, 6 | 7, 9
    //       l2 mid2
    //           r2
    int left = k;

    int low = Math.max(0, k - m);
    int high = Math.min(k, n);
    while (low <= high) {
      int mid1 = (low + high) / 2;
      int mid2 = left - mid1;

      // set to int min if not selecting anything from arr1 left half
      int l1 = mid1 > 0 ? arr1[mid1 - 1] : Integer.MIN_VALUE;
      // set to int min if not selecting anything from arr2 left half
      int l2 = mid2 > 0 ? arr2[mid2 - 1] : Integer.MIN_VALUE;
      // set to int max if not selecting anything from arr1 right half
      int r1 = mid1 < n ? arr1[mid1] : Integer.MAX_VALUE;
      // set to int max if not selecting anything from arr2 right half
      int r2 = mid2 < n ? arr2[mid2] : Integer.MAX_VALUE;

      if (l1 <= r2 && l2 <= r1) {
        return Math.max(l1, l2);
      } else if (l1 > r2) {
        high = mid1 - 1;
      } else {
        low = mid1 + 1;
      }
    }
    return -1;
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

    if (ele != -1) {
      return ele;
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
