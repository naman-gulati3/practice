package com.practice.miscellaneous;

import java.util.Arrays;

public class LargestNumber {

  public static String largestNumber(int[] nums) {
    String[] strNums = Arrays.stream(nums)
        .mapToObj(String::valueOf)
        .toArray(String[]::new);

    // Sort the array with custom comparator
    Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));

    // If the largest number is '0', return '0'
    if (strNums[0].equals("0")) {
      return "0";
    }

    // Build the largest number by concatenating sorted numbers
    StringBuilder sb = new StringBuilder();
    for (String num : strNums) {
      sb.append(num);
    }

    return sb.toString();
  }


  public static void main(String[] args) {
    System.out.println(largestNumber(new int[]{0, 0})); // 95345330
    // 9,5,399,34,3,30
  }
}
