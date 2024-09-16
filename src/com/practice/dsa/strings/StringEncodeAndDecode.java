package com.practice.dsa.strings;

import java.util.ArrayList;
import java.util.List;

public class StringEncodeAndDecode {

  public static String encode(List<String> strs) {
    StringBuilder sb = new StringBuilder();
    for (String word : strs) {
      sb.append(word.length()).append("#").append(word);
    }
    return sb.toString();
  }

  public static List<String> decode(String str) {
    List<String> words = new ArrayList<>();
    int i = 0;

    while (i < str.length()) {
      // Parse the length of the word (could be more than one digit)
      int j = i;
      while (str.charAt(j) != '#') {
        j++;
      }

      // Extract the length of the word
      int wordLength = Integer.parseInt(str.substring(i, j));

      // Extract the word using the parsed length
      String word = str.substring(j + 1, j + 1 + wordLength);

      // Add the word to the list of words
      words.add(word);

      // Move the pointer `i` to the next word section
      i = j + 1 + wordLength;
    }

    return words;
  }

  public static void main(String[] args) {
    List<String> str = List.of("we", "say", ":", "yes", "!@#$%^&*()");
    String encoded = encode(str);
    System.out.println(encoded);
    System.out.println(decode(encoded));
  }
}
