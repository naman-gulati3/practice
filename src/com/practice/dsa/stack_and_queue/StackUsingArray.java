package com.practice.dsa.stack_and_queue;

public class StackUsingArray {

  class MyStack {

    private int[] arr;
    private int top;

    public MyStack() {
      arr = new int[1000];
      top = -1;
    }

    public void push(int x) {
      if (top + 1 >= arr.length) {
        throw new IllegalArgumentException("Stack already full");
      }
      top++;
      arr[top] = x;
    }

    public int pop() {
      if (top < 0) {
        return -1;
      }
      int elem = arr[top];
      arr[top] = -1;
      top--;
      return elem;
    }
  }
}
