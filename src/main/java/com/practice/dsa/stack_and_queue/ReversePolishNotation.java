package com.practice.dsa.stack_and_queue;

import java.util.Stack;

public class ReversePolishNotation {

  public static int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>();
    for (String token : tokens) {
      switch (token) {
        case "+" -> stack.push(stack.pop() + stack.pop());
        case "*" -> stack.push(stack.pop() * stack.pop());
        case "-" -> {
          int second = stack.pop();
          int first = stack.pop();

          stack.push(first - second);
        }
        case "/" -> {
          int second = stack.pop();
          int first = stack.pop();

          stack.push(first / second);
        }
        default -> stack.push(Integer.parseInt(token));
      }
    }

    return stack.peek();
  }

  public static void main(String[] args) {
    System.out.println(evalRPN(new String[] {"2", "1", "+", "3", "*"}));
  }
}
