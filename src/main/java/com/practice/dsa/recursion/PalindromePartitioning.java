package com.practice.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

  public static void main(String[] args) {
    System.out.println(partition("aab"));
  }

  public static List<List<String>> partition(String s) {
    List<List<String>> result = new ArrayList<>();

    recurse(result, s, new ArrayList<>(), 0);
    return result;
  }

  private static void recurse(
      List<List<String>> result, String s, ArrayList<String> currentSet, int current) {
    if (current == s.length()) {
      result.add(new ArrayList<>(currentSet));
      return;
    }

    for (int i = current; i < s.length(); i++) {
      if (isPalimdrome(s, current, i)) {
        // end index is exclusive
        currentSet.add(s.substring(current, i + 1));
        recurse(result, s, currentSet, i + 1);
        currentSet.remove(currentSet.size() - 1);
      }
    }
  }

  private static boolean isPalimdrome(String s, int current, int i) {
    while (current < i) {
      if (s.charAt(current) != s.charAt(i)) {
        return false;
      }
      current++;
      i--;
    }
    return true;
  }
}
