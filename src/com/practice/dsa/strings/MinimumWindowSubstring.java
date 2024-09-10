package com.practice.dsa.strings;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

  public static String minWindow(String s, String t) {
    Map<Character, Integer> map = new HashMap<>();

    for (char ch : t.toCharArray()) {
      if (map.containsKey(ch)) {
        map.put(ch, map.get(ch) + 1);
      } else {
        map.put(ch, 1);
      }
    }

    int l = 0;
    int r = 0;
    int counter = map.size();
    int n = s.length();
    int len = Integer.MAX_VALUE;
    int startIdx = -1;
    while (r < n) {
      char endChar = s.charAt(r);
      // Only decrease counter when a character count reaches 0 (meaning all occurrences are satisfied)
      if (map.containsKey(endChar)) {
        map.put(endChar, map.get(endChar) - 1);
        if (map.get(endChar) == 0) {
          counter--;
        }
      }

      // When all characters are satisfied (counter == 0), try to shrink the window
      // counter == 0 means we have a valid answer
      while (counter == 0) {
        if (r - l + 1 < len) {
          startIdx = l;
          len = r - l + 1;
        }

        char startChar = s.charAt(l);
        if (map.containsKey(startChar)) {
          map.put(startChar, map.get(startChar) + 1);

          // If a character count becomes positive, it means we need more of that character
          if (map.get(startChar) > 0) {
            counter++;
          }
        }
        l++;
      }

      r++;
    }
    return len == Integer.MAX_VALUE ? "" : s.substring(startIdx, startIdx + len);
  }

  public static void main(String[] args) {
    System.out.println(minWindow("ADOBECODEBANC", "ABC"));
  }
}
