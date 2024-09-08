package com.practice.dsa.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

  public static List<List<String>> groupAnagrams(String[] strs) {
    String[] sorted = new String[strs.length];
    for (int i = 0; i < strs.length; i++) {
      char[] chars = strs[i].toCharArray();
      Arrays.sort(chars);
      sorted[i] = new String(chars);
    }

    Map<String, List<String>> mp = new HashMap<>();

    for (int i = 0; i < strs.length; i++) {
      mp.computeIfAbsent(sorted[i], k -> new ArrayList<>()).add(strs[i]);
    }

    return new ArrayList<>(mp.values());
  }

  public static void main(String[] args) {
    System.out.println(groupAnagrams(new String[]{"act", "pots", "tops", "cat", "stop", "hat"}));
  }
}
