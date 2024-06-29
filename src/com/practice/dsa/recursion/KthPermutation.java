package com.practice.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class KthPermutation {

  public static void main(String[] args) {
    System.out.println(getPermutation(3, 3));
  }

  public static String getPermutation(int n, int k) {
    List<Integer> numbers = new ArrayList<>();
    int fact = 1;

    // if n = 3 there are 2! combinations for first digit
    // store these digits in numbers list
    for (int i = 1; i < n; i++) {
      numbers.add(i);
      fact = fact * i;
    }

    numbers.add(n);
    StringBuilder ans = new StringBuilder();

    // 0 based indexing, if we have to find 17th permutation find 16th permutation
    k = k - 1;

    while (true) {
      // divides numbers into blocks and picks correct number for first position from this block
      // numbers.get(3 / 2) from [1, 2, 3] = 2 for first iteration
      ans.append(numbers.get(k / fact));
      // remove the used number from list because ofc same number (index) will not be reused
      numbers.remove(k / fact);
      if (numbers.isEmpty()) {
        break;
      }

      // reduce k (3 / 2) = 1
      // so in next iteration the possible numbers for second position will be 1! (1, 3 are left)
      // similarly in last iteration the possible numbers for third position will be 0! i.e 0th index
      k = k % fact;

      // factorial will reduce by factor of 1 i.e from 3! to 2! to 1! etc.
      fact = fact / numbers.size();
    }
    return ans.toString();
  }
}
