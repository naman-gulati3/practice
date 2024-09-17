package com.practice.dsa.stack_and_queue;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperature {

  public static int[] dailyTemperatures(int[] temperatures) {
    int[] result = new int[temperatures.length];

    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < temperatures.length; i++) {
      while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
        int idx = stack.pop();
        result[idx] = i - idx;
      }
      stack.push(i);
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(dailyTemperatures(new int[] {30, 38, 30, 36, 35, 40, 28})));
  }
}
