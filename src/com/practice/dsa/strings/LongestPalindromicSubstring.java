package com.practice.dsa.strings;

public class LongestPalindromicSubstring {

  public static String longestPalindrome(String s) {
    if (s.length() <= 1) {
      return s;
    }

    String maxString = s.substring(0, 1);

    for (int i = 0; i < s.length(); i++) {
      String odd = expandFromCenter(s, i, i);
      String even = expandFromCenter(s, i, i + 1);

      if (odd.length() > maxString.length()) {
        maxString = odd;
      }

      if (even.length() > maxString.length()) {
        maxString = even;
      }
    }
    return maxString;
  }

  private static String expandFromCenter(String s, int start, int end) {
    while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
      start--;
      end++;
    }
    return s.substring(start + 1, end);
  }

  public static void main(String[] args) {
    System.out.println(longestPalindrome("babad"));
  }
}
