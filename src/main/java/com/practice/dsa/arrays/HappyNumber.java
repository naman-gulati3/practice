package com.practice.dsa.arrays;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

  public static boolean isHappy(int n) {
    Set<Integer> seen = new HashSet<>();

    while (true) {
      int sum = 0;
      while (n > 0) {
        int remainder = n % 10;
        sum += remainder * remainder;
        n /= 10;
      }
      if (sum == 1) {
        return true;
      }

      if (seen.contains(sum)) {
        return false;
      }
      seen.add(sum);
      n = sum;
    }
  }

  public static void main(String[] args) {
    System.out.println(isHappy(7));
    // 7^2 = 49
    // 16 + 81 = 97
    // 81 + 49 = 130
    // 1 + 9 + 0 = 10
    // 1 = true
  }
}
