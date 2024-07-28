package com.practice.dsa.strings;

import java.util.HashMap;
import java.util.Map;

public class AnagramCheck {

  public static void main(String[] args) {
    System.out.println(isAnagram("yqhbicoumu", "ouiuycbmqh"));
  }

  public static boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    Map<Character, Integer> map = new HashMap<>();
    for (char ch : s.toCharArray()) {
      if (map.containsKey(ch)) {
        map.put(ch, map.get(ch) + 1);
      } else {
        map.put(ch, 1);
      }
    }

    for (char ch : t.toCharArray()) {
      if (map.containsKey(ch)) {
        int val = map.get(ch) - 1;
        if (val == 0) {
          map.remove(ch);
        } else {
          map.put(ch, val);
        }
      }
    }

    return map.isEmpty();
  }
}
