package com.practice.dsa.strings;

public class RabinKarpPatternMatching {

  private static final double PRIME = 7;

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

  public static boolean repeatedStringMatch2(String pattern, String text) {
    double patternHash = calculateHash(pattern);
    double strHash = calculateHash(text.substring(0, pattern.length()));
    int count = 0;
    for (int i = 0; i < text.length() - pattern.length(); i++) {
      String textWindow = text.substring(i, i + pattern.length());
      if (strHash == patternHash) {
        if (checkWindow(textWindow, pattern)) {
          return true;
        }
      }

      if (i < text.length() - pattern.length()) {
        strHash =
            updateHash(
                strHash, text.charAt(i), text.charAt(i + pattern.length()), pattern.length());
      }
    }
    return false;
  }

  private static boolean checkWindow(String window, String a) {
    return window.equals(a);
  }

  private static double calculateHash(String pattern) {
    double hash = 0;
    for (int i = 0; i < pattern.length(); i++) {
      hash = hash + pattern.charAt(i) * Math.pow(PRIME, i);
    }
    return hash;
  }

  private static double updateHash(double prevHash, char oldChar, char newChar, int patternLength) {
    double newHash = (prevHash - oldChar) / PRIME;
    // patternLength - 1 because we are only updating the hash with last character so its index in
    // this window
    // will always be patternLength - 1 (refer to the loop above in calculateHash which goes from 0
    // to patternLength - 1)
    newHash = newHash + newChar * Math.pow(PRIME, patternLength - 1);
    return newHash;
  }

  public static void main(String[] args) {
    System.out.println(repeatedStringMatch("abcd", "cdabcdab"));
    System.out.println(repeatedStringMatch2("abcd", "cdabcdab"));
  }
}
