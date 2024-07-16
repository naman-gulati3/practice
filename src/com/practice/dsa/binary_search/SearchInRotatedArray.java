package com.practice.dsa.binary_search;

public class SearchInRotatedArray {

  public static void main(String[] args) {
    System.out.println(search(new int[]{5, 1, 3}, 4));
  }

  public static int search(int[] nums, int target) {
    int low = 0;
    int high = nums.length - 1;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (target == nums[mid]) {
        return mid;
      }
      // if left half is sorted
      if (nums[low] <= nums[mid]) {
        if (target < nums[mid] && target >= nums[low]) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      } else {
        // right half is sorted
        if (nums[high] >= nums[mid]) {
          if (target <= nums[high] && target > nums[mid]) {
            low = mid + 1;
          } else {
            high = mid - 1;
          }
        }
      }
    }
    return -1;
  }
}
