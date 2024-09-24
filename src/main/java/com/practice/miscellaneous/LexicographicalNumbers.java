package com.practice.miscellaneous;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {

  public static List<Integer> lexicalOrder(int n) {
    List<Integer> result = new ArrayList<>();

    for (int i = 1; i <= 9; i++) {
      dfs(i, result, n);
    }

    return result;
  }

  private static void dfs(int curr, List<Integer> result, int n) {
    if (curr > n) {
      return;
    }

    result.add(curr);
    for (int nextDigit = 0; nextDigit <= 9; nextDigit++) {
      int nextNum = curr * 10 + nextDigit;
      if (nextNum <= n) {
        dfs(nextNum, result, n);
      } else {
        break;
      }
    }
  }

  public static void main(String[] args) {
    System.out.println(lexicalOrder(18));
  }
}
