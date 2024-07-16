package com.practice.dsa.stack_and_queue;

import java.util.Stack;

public class SortStack {

  public static void sortStack(Stack<Integer> stack) {
    if (!stack.isEmpty()) {
      int top = stack.pop();
      sortStack(stack);
      insertInCorrectPosition(stack, top);
    }
  }

  private static void insertInCorrectPosition(Stack<Integer> stack, int top) {
    if (stack.isEmpty() || stack.peek() < top) {
      stack.push(top);
    } else {
      int temp = stack.pop();
      insertInCorrectPosition(stack, top);
      stack.push(temp);
    }
  }

  public static void sortStack2(Stack<Integer> stack) {
    Stack<Integer> auxStack = new Stack<>();

    while (!stack.isEmpty()) {
      int top = stack.pop();
      while (!auxStack.isEmpty() && auxStack.peek() < top) {
        stack.push(auxStack.pop());
      }
      auxStack.push(top);
    }
 
    while (!auxStack.isEmpty()) {
      stack.push(auxStack.pop());
    }
  }


  public static void main(String[] args) {
    var s = new Stack<Integer>();
    s.push(4);
    s.push(3);
    s.push(1);
    s.push(5);
    s.push(2);
    sortStack2(s);
    System.out.println(s);
  }
}
