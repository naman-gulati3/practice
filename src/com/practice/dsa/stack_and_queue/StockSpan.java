package com.practice.dsa.stack_and_queue;

import java.util.Stack;

public class StockSpan {

  record Pair(int price, int consecutiveDays) {

  }

  // previous smaller
  static class StockSpanner {

    private final Stack<Pair> stack;

    public StockSpanner() {
      this.stack = new Stack<>();

    }

    public int next(int price) {
      int ans = 1;
      while (!stack.isEmpty() && stack.peek().price <= price) {
        ans = ans + stack.pop().consecutiveDays;
      }
      stack.push(new Pair(price, ans));
      return ans;
    }
  }

  public static void main(String[] args) {
    StockSpanner stockSpanner = new StockSpanner();
    System.out.println(stockSpanner.next(100)); // return 1
    System.out.println(stockSpanner.next(80));  // return 1
    System.out.println(stockSpanner.next(60));  // return 1
    System.out.println(stockSpanner.next(70));  // return 2
    System.out.println(stockSpanner.next(60));  // return 1
    System.out.println(stockSpanner.next(75));  // return 4, because the last 4 prices
    // (including today's) price of 75) were less than or equal to today's price.
    System.out.println(stockSpanner.next(85));  // return 6
  }
}
