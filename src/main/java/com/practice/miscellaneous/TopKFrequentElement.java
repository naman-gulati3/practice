package com.practice.miscellaneous;

import java.util.HashMap;
import java.util.Map;

public class TopKFrequentElement {

  public static int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    var sortedEntries =
        map.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed());
    int[] res = new int[k];
    int i = 0;
    for (var entry : sortedEntries.toList()) {
      if (i == k) {
        break;
      }
      res[i] = entry.getKey();
      i++;
    }

    return res;
  }

  public static void main(String[] args) {}
}
