package com.practice.dsa.stack_and_queue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextSmallerElement {

  public static int[] prevSmaller(int[] A) {
    Stack<Integer> stack = new Stack<>();
    Map<Integer, Integer> map = new HashMap<>();
    int[] result = new int[A.length];

    for (int i = A.length - 1; i >= 0; i--) {
      int num = A[i];
      while (!stack.isEmpty() && stack.peek() > num) {
        map.put(stack.pop(), num);
      }
      stack.add(num);
    }

    for (int i = 0; i < A.length; i++) {
      result[i] = map.getOrDefault(A[i], -1);
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(prevSmaller(new int[]{4, 5, 2, 10, 8})));
  }
}
