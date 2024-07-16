package com.practice.dsa.stack_and_queue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {

  public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
    Stack<Integer> stack = new Stack<>();
    Map<Integer, Integer> map = new HashMap<>();

    int[] result = new int[nums1.length];

    int n = nums1.length;
    for (int num : nums2) {
      // The inner while loop checks if the stack is not empty and the top element of the stack is less than the current element (num).
      // If so, it means the current element (num) is the next greater element for the top element of the stack.
      // This top element is then popped from the stack, and the mapping is added to the map.
      while (!stack.isEmpty() && stack.peek() < num) {
        map.put(stack.pop(), num);
      }
      stack.push(num);
    }

    for (int i = 0; i < n; i++) {
      result[i] = map.getOrDefault(nums1[i], -1);
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(
        Arrays.toString(nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
  }
}
