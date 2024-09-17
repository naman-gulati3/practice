package com.practice.dsa.stack_and_queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

  static class MyStack {

    final Queue<Integer> q;

    public MyStack() {
      q = new LinkedList<>();
    }

    public void push(int x) {
      q.add(x);
      for (int i = 0; i < q.size() - 1; i++) {
        q.add(q.poll());
      }
    }

    public int pop() {
      if (q.isEmpty()) {
        return -1;
      }
      return q.poll();
    }

    public int top() {
      if (q.isEmpty()) {
        return -1;
      }
      return q.peek();
    }

    public boolean empty() {
      return q.isEmpty();
    }
  }

  public static void main(String[] args) {
    var s = new MyStack();
    s.push(1);
    s.push(2);
    s.push(3);
    s.push(4);

    System.out.println(s.q);
  }
}
