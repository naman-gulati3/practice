package com.practice.dsa.stack_and_queue;

import java.util.Stack;

public class QueueUsingStack {

  static class MyQueue {

    private final Stack<Integer> inputStack;
    private final Stack<Integer> outputStack;

    public MyQueue() {
      inputStack = new Stack<>();
      outputStack = new Stack<>();
    }

    public void push(int x) {
      inputStack.push(x);
    }

    public int pop() {
      if (outputStack.isEmpty()) {
        while (!inputStack.isEmpty()) {
          outputStack.push(inputStack.pop());
        }
      }
      return outputStack.pop();
    }

    public int peek() {
      if (outputStack.isEmpty()) {
        while (!inputStack.isEmpty()) {
          outputStack.add(inputStack.pop());
        }
      }
      return outputStack.peek();
    }

    public boolean empty() {
      return outputStack.isEmpty() && inputStack.isEmpty();
    }
  }
}
