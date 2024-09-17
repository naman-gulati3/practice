package com.practice.dsa.strings;

import java.util.Arrays;

public class LongestCommonPrefix {

  public static String longestCommonPrefix(String[] strs) {
    Arrays.sort(strs);
    String first = strs[0];
    String last = strs[strs.length - 1];

    int i = 0;
    while (i < first.length() && first.charAt(i) == last.charAt(i)) {
      i++;
    }
    return first.substring(0, i);
  }

  public static void main(String[] args) {
    System.out.println(longestCommonPrefix(new String[] {"racecar", "race", "racist"}));
  }
}
