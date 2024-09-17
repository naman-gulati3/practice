package com.practice.dsa.strings;

public class CountAndSay {

  public static String countAndSay(int n) {
    if (n == 1) {
      return "1";
    }

    String s = countAndSay(n - 1);
    int count = 0;
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      count++;
      if (i == s.length() - 1 || s.charAt(i) != s.charAt(i + 1)) {
        builder.append(count).append(s.charAt(i));
        count = 0;
      }
    }
    return builder.toString();
  }

  public static void main(String[] args) {
    System.out.println(countAndSay(4));
  }
}
