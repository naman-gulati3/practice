package com.practice.dsa.stack_and_queue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {

  public static boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    Map<Character, Character> map = new HashMap<>();
    map.put('{', '}');
    map.put('(', ')');
    map.put('[', ']');

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (map.containsKey(ch)) {
        stack.push(ch);
      } else if (!stack.isEmpty() && map.containsValue(ch) && map.get(stack.peek()) == ch) {
        stack.pop();
      } else {
        return false;
      }
    }
    return stack.isEmpty();
  }

  public static void main(String[] args) {
    System.out.println(isValid("()[]{}"));
  }
}
