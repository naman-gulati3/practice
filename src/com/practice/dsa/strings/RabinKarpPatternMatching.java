package com.practice.dsa.strings;

public class RabinKarpPatternMatching {


  public static int repeatedStringMatch(String a, String b) {
    StringBuilder s = new StringBuilder(a);
    int count = 1;
    while (s.length() < b.length()) {
      s.append(a);
      count++;
    }

    if (s.indexOf(b) != -1) {
      return count;
    }

    s.append(a);
    count++;

    if (s.indexOf(b) != -1) {
      return count;
    }
    return -1;
  }

  public static int repeatedStringMatch2(String a, String b) {
    long patternHash = calculateHash(a);
    int count = 0;
//    System.out.println(patternHash);
    for (int i = 0; i < b.length() - a.length() + 1; i++) {
      long textHash = calculateHash(b.substring(i, i + a.length()));
      if (patternHash == textHash) {
        boolean isSame = checkWindow(b.substring(i, i + a.length()), a);
        if (isSame) {
          count++;
        }
      }
    }
    return count;
  }

  private static boolean checkWindow(String window, String a) {
    int i = 0;
    int j = 0;

    while (i < window.length() && j < a.length()) {
      if (window.charAt(i) != a.charAt(j)) {
        return false;
      }
      i++;
      j++;
    }
    return true;
  }

  private static long calculateHash(String s) {
    long hash = 0;
    for (int i = 0; i < s.length(); i++) {
      hash += (long) Math.pow(256, s.length() - i - 1) % 101;
    }
    return hash;
  }

  public static void main(String[] args) {
    System.out.println(repeatedStringMatch("abcd", "cdabcdab"));
  }
}
