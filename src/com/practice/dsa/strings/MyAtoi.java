package com.practice.dsa.strings;

public class MyAtoi {

  public static int myAtoi(String s) {
    int res = 0;
    int sign = 1;
    int i = 0;
    int n = s.length();

    while (i < n && s.charAt(i) == ' ') {
      i++;
    }

    if (i < n && (s.charAt(i) == '-') || s.charAt(i) == '+') {
      if (s.charAt(i) == '-') {
        sign = -1;
      }
      i++;
    }

    while (i < n && 0 <= s.charAt(i) - '0' && s.charAt(i) - '0' <= 9) {
      int digit = s.charAt(i) - '0';
      if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10
          && digit > Integer.MAX_VALUE % 10)) {
        return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
      }
      res = res * 10 + digit;
      i++;
    }
    return res * sign;
  }

  public static void main(String[] args) {
    System.out.println(myAtoi("42"));
  }

}
