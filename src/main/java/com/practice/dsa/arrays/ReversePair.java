package com.practice.dsa.arrays;

public class ReversePair {
  // https://leetcode.com/problems/reverse-pairs/
  // left element should be > 2* right element to form a pair
  // for eg. (4, 1), (3, 1), (5, 1)
  public static void main(String[] args) {
    System.out.println(reversePairs(new int[] {2, 4, 3, 5, 1}));
  }

  public static int reversePairs(int[] nums) {
    int low = 0;
    int high = nums.length - 1;
    return mergeSort(nums, low, high);
  }

  private static int mergeSort(int nums[], int low, int high) {
    if (low >= high) {
      return 0;
    }

    int mid = low + (high - low) / 2;
    int count = mergeSort(nums, low, mid) + mergeSort(nums, mid + 1, high);

    count += countPairs(nums, low, mid, high);
    merge(nums, low, mid, high);
    return count;
  }

  private static int countPairs(int[] nums, int low, int mid, int high) {
    int right = mid + 1;
    int count = 0;
    for (int i = low; i <= mid; i++) {
      while (right <= high && nums[i] > 2 * nums[right]) {
        right++;
      }
      count += (right - (mid + 1));
    }
    return count;
  }

  private static void merge(int[] nums, int low, int mid, int high) {
    int left = mid - low + 1;
    int right = high - mid;

    int[] leftArr = new int[left];
    int[] rightArr = new int[right];

    for (int i = 0; i < left; i++) {
      leftArr[i] = nums[low + i];
    }

    for (int j = 0; j < right; j++) {
      rightArr[j] = nums[mid + j + 1];
    }

    int k = low;
    int i = 0, j = 0;

    while (i < left && j < right) {
      if (leftArr[i] < rightArr[j]) {
        nums[k] = leftArr[i];
        i++;
      } else {
        nums[k] = rightArr[j];
        j++;
      }
      k++;
    }

    while (i < left) {
      nums[k] = leftArr[i];
      i++;
      k++;
    }

    while (j < right) {
      nums[k] = rightArr[j];
      j++;
      k++;
    }
  }
}
