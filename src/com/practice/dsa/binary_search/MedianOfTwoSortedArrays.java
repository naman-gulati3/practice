package com.practice.dsa.binary_search;

public class MedianOfTwoSortedArrays {

  public static void main(String[] args) {
    System.out.println(
        findMedianSortedArraysOptimal(new int[]{2, 3, 6, 15}, new int[]{1, 4, 7, 10, 12}));
  }

  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int count = 0;
    int ind1Elem = -1;
    int ind2Elem = -1;

    int n1 = nums1.length;
    int n2 = nums2.length;

    int i = 0;
    int j = 0;
    int n = n1 + n2;
    int ind2 = n / 2;
    int ind1 = ind2 - 1;

    while (i < n1 && j < n2) {
      if (nums1[i] < nums2[j]) {
        if (count == ind1) {
          ind1Elem = nums1[i];
        }

        if (count == ind2) {
          ind2Elem = nums1[i];
        }
        count++;
        i++;
      } else {
        if (count == ind1) {
          ind1Elem = nums2[j];
        }

        if (count == ind2) {
          ind2Elem = nums2[j];
        }
        count++;
        j++;
      }

      while (i < n1) {
        if (count == ind1) {
          ind1Elem = nums1[i];
        }

        if (count == ind2) {
          ind2Elem = nums1[i];
        }
        count++;
        i++;
      }

      while (j < n2) {
        if (count == ind1) {
          ind1Elem = nums2[j];
        }

        if (count == ind2) {
          ind2Elem = nums2[j];
        }
        count++;
        j++;
      }
    }
    if (n % 2 == 1) {
      return ind2Elem;
    } else {
      return (double) (ind1Elem + ind2Elem) / 2;
    }
  }

  // 2 3 6 15
  // 1 4 7 10 12
  // mid = 5: (4 + 5 + 1) / 2

  // sorted: 1 2 3 4 6 7 10 12 15
  // initial partition:

  // 2 3    | 6  15
  // 1 4 7  | 10 12
  // high = 4, low = 0
  //

  // final partitioning:
  // 2 3 6 | 15
  // 1 4   | 7 10 12
  public static double findMedianSortedArraysOptimal(int[] nums1, int[] nums2) {
    int n1 = nums1.length;
    int n2 = nums2.length;

    if (n1 > n2) {
      return findMedianSortedArraysOptimal(nums2, nums1);
    }

    int total = n1 + n2;
    // elements on the left partition
    int left = (n1 + n2 + 1) / 2;
    int low = 0;
    int high = n1;

    while (low <= high) {
      int mid1 = (low + high) / 2;
      int mid2 = left - mid1;

      int l1 = mid1 > 0 ? nums1[mid1 - 1] : Integer.MIN_VALUE;
      int l2 = mid2 > 0 ? nums2[mid2 - 1] : Integer.MIN_VALUE;
      int r1 = mid1 < n1 ? nums1[mid1] : Integer.MAX_VALUE;
      int r2 = mid2 < n2 ? nums2[mid2] : Integer.MAX_VALUE;

      if (l1 <= r2 && l2 <= r1) {
        if (total % 2 == 1) {
          return Math.max(l1, l2);
        } else {
          return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
        }
      } else if (l1 > r2) {
        // high was at n1. Trim it down to take less elements from nums1 and more from nums2
        high = mid1 - 1;
      } else {
        // low was at 0.
        low = mid1 + 1;
      }
    }
    return -1;
  }
}
