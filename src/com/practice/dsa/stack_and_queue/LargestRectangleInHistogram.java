package com.practice.dsa.stack_and_queue;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram {

  public static int largestRectangleArea(int[] heights) {
    int n = heights.length;
    int[] rightSmall = new int[heights.length];
    int[] leftSmall = new int[heights.length];
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < n; i++) {
      while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
        stack.pop();
      }
      if (stack.isEmpty()) {
        leftSmall[i] = 0;
      } else {
        // +1 because stack is storing indexes
        leftSmall[i] = stack.peek() + 1;
      }
      stack.push(i);
    }

    while (!stack.isEmpty()) {
      stack.pop();
    }

    for (int i = n - 1; i >= 0; i--) {
      while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
        stack.pop();
      }

      if (stack.isEmpty()) {
        rightSmall[i] = n - 1;
      } else {
        rightSmall[i] = stack.peek() - 1;
      }
      stack.push(i);
    }

    int maxA = 0;
    for (int i = 0; i < n; i++) {
      System.out.println(Arrays.toString(rightSmall));
      System.out.println(Arrays.toString(leftSmall));
      maxA = Math.max(maxA, heights[i] * (rightSmall[i] - leftSmall[i] + 1));
    }
    return maxA;
  }

  public static void main(String[] args) {
    System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
  }
}
