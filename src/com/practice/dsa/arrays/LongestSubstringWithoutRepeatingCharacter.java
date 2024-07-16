package com.practice.dsa.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacter {

  public static void main(String[] args) {
    System.out.println(lengthOfLongestSubstring("pwwkew"));
    System.out.println(lengthOfLongestSubstringOptimal("pwwkew"));
  }

  public static int lengthOfLongestSubstring(String s) {
    int maxString = 0;
    int l = 0;
    int r = 0;

    Set<Character> set = new HashSet<>();

    while (r < s.length()) {
      if (!set.contains(s.charAt(r))) {
        set.add(s.charAt(r));
        maxString = Math.max(maxString, r - l + 1);
      } else {
        while (set.contains(s.charAt(r))) {
          set.remove(s.charAt(l));
          l++;
        }
        set.add(s.charAt(r));
      }
      r++;
    }
    return maxString;
  }

  public static int lengthOfLongestSubstringOptimal(String s) {
    int maxString = 0;
    int l = 0;
    int r = 0;

    Map<Character, Integer> map = new HashMap<>();

    while (r < s.length()) {
      if (map.containsKey(s.charAt(r))) {
        l = Math.max(map.get(s.charAt(r)) + 1, l);
      }
      map.put(s.charAt(r), r);
      maxString = Math.max(maxString, r - l + 1);
      r++;
    }
    return maxString;
  }

}