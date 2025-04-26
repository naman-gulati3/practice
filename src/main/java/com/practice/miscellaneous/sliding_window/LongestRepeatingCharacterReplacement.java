package com.practice.miscellaneous.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAB", 2));
    }

    public static int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();

        int l = 0;
        int max = 0;
        int res = 0;

        for(int r = 0; r < s.length(); r++) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            max = Math.max(max, map.get(s.charAt(r)));


            while((r - l + 1) - max > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }

            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
