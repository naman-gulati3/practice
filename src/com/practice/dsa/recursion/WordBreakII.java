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
    List<String> result = new ArrayList<>();

    recurse(s, new HashSet<>(wordDict), result, 0, "");
//    recurse(0, 0, result, new ArrayList<>(), new HashSet<>(wordDict), s);
    return result;
  }

  private static void recurse(String str, Set<String> dict, List<String> result, int start,
      String currentStr) {
    if (start == str.length()) {
      // -1 because empty string is at appended to string
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

  private static void recurse(int start, int end, List<String> result, List<String> curr,
      Set<String> dict,
      String str) {
    if (end == str.length() - 1) {
      if (dict.contains(str.substring(start, end + 1))) {
        curr.add(str.substring(start, end + 1));
        result.add(String.join(" ", curr));
        curr.remove(curr.size() - 1);
      }
      return;
    }

    // pick
    if (dict.contains(str.substring(start, end + 1))) {
      curr.add(str.substring(start, end + 1));
      recurse(start + 1, end + 1, result, curr, dict, str);
      curr.remove(curr.size() - 1);
    }

    // not pick
    recurse(start, end + 1, result, curr, dict, str);
  }
}
