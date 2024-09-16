package com.practice.dsa.strings;

public class RepeatedSubstringPattern {


  public static boolean repeatedSubstringPatternBetter(String s) {
    String doubled = s + s;
    String sub = doubled.substring(1, doubled.length() - 1);
    return sub.contains(s);
  }

  public static boolean repeatedSubstringPattern(String s) {
    int n = s.length();
    int mid = n / 2;

    for (int i = 0; i < mid; i++) {
      String subString = s.substring(0, i + 1);
      subString = matchLength(s.length(), subString);
      if (subString.equals(s)) {
        return true;
      }
    }
    // abcabcabc

    return false;
  }

  private static String matchLength(int l, String s) {
    StringBuilder sb = new StringBuilder(s);

    while (sb.length() < l) {
      sb.append(s);
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(repeatedSubstringPattern("abcabcabc"));
    System.out.println(repeatedSubstringPattern("abab"));
    System.out.println(repeatedSubstringPattern("aba"));
    System.out.println(repeatedSubstringPattern("a"));
  }
}
