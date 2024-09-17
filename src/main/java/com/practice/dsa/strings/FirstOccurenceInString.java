package com.practice.dsa.strings;

public class FirstOccurenceInString {

  public static int strStr(String haystack, String needle) {
    if (needle.length() > haystack.length()) {
      return -1;
    }

    int n = haystack.length() - needle.length();

    for (int i = 0; i <= n; i++) {
      String subs = haystack.substring(i, i + needle.length());
      if (subs.equals(needle)) {
        return i;
      }
    }
    return -1;
  }

  public static int kmp(String haystack, String needle) {
    if (needle.length() > haystack.length()) {
      return -1;
    }

    int[] lps = computeLPSArray(needle);

    int i = 0;
    int j = 0;
    while (j < needle.length() && i < haystack.length()) {
      if (needle.charAt(j) == haystack.charAt(i)) {
        j++;
        i++;
      } else {
        if (j != 0) {
          j = lps[j - 1];
        } else {
          i++;
        }
      }
    }

    if (j == needle.length()) {
      return i - j;
    } else {
      return -1;
    }
  }

  private static int[] computeLPSArray(String pattern) {
    int[] lps = new int[pattern.length()];
    int previousLPS = 0; // length of the previous longest prefix suffix
    int i = 1;
    lps[0] = 0; // lps[0] is always 0

    // aabaa
    // [0] i = 1, len = 0
    // [0, 1] i = 2, len = 1
    // [0, 1, 0] i = 2, len = 0
    // [0, 1, 0] i = 3, len = 0
    // [0, 1, 0, 1] i = 4, len = 1
    // [0, 1, 0, 1, 2] i = 5, len = 2

    while (i < pattern.length()) {
      if (pattern.charAt(i) == pattern.charAt(previousLPS)) {
        previousLPS++;
        lps[i] = previousLPS;
        i++;
      } else {
        if (previousLPS != 0) {
          previousLPS = lps[previousLPS - 1];
        } else {
          lps[i] = 0;
          i++;
        }
      }
    }
    return lps;
  }

  public static void main(String[] args) {
    System.out.println(kmp("leetcode", "tco"));
  }
}
