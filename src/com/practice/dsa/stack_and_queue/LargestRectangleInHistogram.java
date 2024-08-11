package com.practice.dsa.stack_and_queue;

import java.util.Stack;

public class LargestRectangleInHistogram {

  public static int largestRectangleArea(int[] heights) {
    int n = heights.length;
    int[] rightSmall = new int[heights.length];
    int[] leftSmall = new int[heights.length];
    Stack<Integer> stack = new Stack<>();

    // find left small
    for (int i = 0; i < n; i++) {
      // if stack has something bigger than current element, pop it until it has smaller element
      while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
        stack.pop();
      }
      // if stack is empty left smaller does not exist
      if (stack.isEmpty()) {
        leftSmall[i] = 0;
      } else {
        // The +1 adjusts the index to reflect the start of the valid range for the rectangle.
        leftSmall[i] = stack.peek() + 1;
      }
      stack.push(i);
    }

    // clear the stack to reuse for calculating right small
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
      maxA = Math.max(maxA, heights[i] * (rightSmall[i] - leftSmall[i] + 1));
    }
    return maxA;
  }

  public static void main(String[] args) {
    System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
  }
}
