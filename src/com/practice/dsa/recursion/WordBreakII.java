package com.practice.dsa.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII {

  public static void main(String[] args) {
    System.out.println(wordBreak("catsanddog", List.of("cat", "cats", "and", "sand", "dog")));
  }

  public static List<String> wordBreak(String s, List<String> wordDict) {
    Set<String> dict = new HashSet<>(wordDict);
    List<String> result = new ArrayList<>();

    recurse(s, dict, result, 0, "");
    return result;
  }

  private static void recurse(String str, Set<String> dict, List<String> result, int start,
      String currentStr) {
    if (start == str.length()) {
      result.add(currentStr.substring(0, currentStr.length() - 1));
      return;
    }

    for (int i = start; i < str.length(); i++) {
      String subStr = str.substring(start, i + 1);
      if (!dict.contains(subStr)) {
        continue;
      }

      recurse(str, dict, result, i + 1, currentStr + subStr + " ");
    }
  }
}
