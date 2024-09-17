package com.practice.dsa.binary_search;

public class SingleElementInSortedArray {

  public static void main(String[] args) {
    System.out.println(singleNonDuplicate(new int[] {1, 1, 2, 2, 3, 4, 4, 8, 8}));
    System.out.println(singleNonDuplicate2(new int[] {1, 1, 2, 2, 3, 4, 4, 8, 8}));
  }

  public static int singleNonDuplicate(int[] nums) {
    int low = 0;
    int high = nums.length - 1;

    while (low < high) {
      int mid = (low + high) / 2;
      if ((mid % 2 == 0 && nums[mid + 1] == nums[mid])
          || mid % 2 == 1 && nums[mid] == nums[mid - 1]) {
        // if the above property is satisfied it means left part has no missing duplicate
        low = mid + 1;
      } else {
        high = mid;
      }
    }
    return nums[low];
  }

  public static int singleNonDuplicate2(int[] nums) {
    int xor = 0;
    for (int num : nums) {
      xor ^= num;
    }
    return xor;
  }
}
