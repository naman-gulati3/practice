package com.practice.dsa.arrays;

public class TrappingRainwater {

  public static int trap(int[] height) {
    int left = 0;
    int right = height.length - 1;
    int leftMax = 0;
    int rightMax = 0;
    int max = 0;

    while (left < right) {
      // on the right there is some building taller than left building
      if (height[left] <= height[right]) {
        if (height[left] >= leftMax) {
          leftMax = height[left];
        } else {
          max += leftMax - height[left];
        }
        left++;
      } else {
        if (height[right] >= rightMax) {
          rightMax = height[right];
        } else {
          max += rightMax - height[right];
        }
        right--;
      }
    }
    return max;
  }

  public static void main(String[] args) {
    System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
  }
}
