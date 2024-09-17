package com.practice.dsa.sorting;

import java.util.Arrays;

public class MergeSort {

  private static int mergeSort(int[] nums, int low, int high) {
    int pairCount = 0;
    if (low < high) {
      int mid = low + (high - low) / 2;
      pairCount += mergeSort(nums, low, mid);
      pairCount += mergeSort(nums, mid + 1, high);

      pairCount += merge(nums, low, mid, high);
    }
    return pairCount;
  }

  private static int merge(int[] nums, int low, int mid, int high) {
    int n1 = mid - low + 1;
    int n2 = high - mid;

    int[] temp1 = new int[n1];
    int[] temp2 = new int[n2];

    int pairCount = 0;
    for (int i = 0; i < n1; i++) {
      temp1[i] = nums[low + i];
    }

    for (int j = 0; j < n2; j++) {
      temp2[j] = nums[mid + j + 1];
    }

    int i = 0, j = 0;
    int k = low;
    while (i < n1 && j < n2) {
      if (temp1[i] <= temp2[j]) {
        nums[k] = temp1[i];
        i++;
      } else {
        pairCount += n1 - low + 1;
        nums[k] = temp2[j];
        j++;
      }
      k++;
    }

    while (i < n1) {
      nums[k] = temp1[i];
      i++;
      k++;
    }

    while (j < n2) {
      nums[k] = temp2[j];
      j++;
      k++;
    }
    return pairCount;
  }

  public static void main(String[] args) {
    int[] arr = new int[] {5, 3, 2, 1, 4};
    // for inverse pair
    // pairs  = (5,2), (5,4), (5,3), (5,1), (4,3), (4, 1), (3,1)
    System.out.println(mergeSort(arr, 0, 4));
    System.out.println(Arrays.toString(arr));
  }
}
