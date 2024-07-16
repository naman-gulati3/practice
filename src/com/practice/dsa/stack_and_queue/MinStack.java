package com.practice.dsa.stack_and_queue;

import java.util.Stack;

class MinStack {

  record Pair(int val, int min) {

  }

  private final Stack<Pair> stack;

  public MinStack() {
    this.stack = new Stack<>();
  }

  public void push(int val) {
    int min;
    if (stack.isEmpty()) {
      min = val;
    } else {
      min = Math.min(stack.peek().min(), val);
    }
    stack.push(new Pair(val, min));
  }

  public void pop() {
    stack.pop();
  }

  public int top() {
    return stack.peek().val();
  }

  public int getMin() {
    return stack.peek().min();
  }
}
