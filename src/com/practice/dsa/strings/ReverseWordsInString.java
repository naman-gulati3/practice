package com.practice.dsa.strings;

public class ReverseWordsInString {

  public static String reverseWords(String s) {
    StringBuilder result = new StringBuilder();
    String[] words = s.split(" ");
    for (int i = words.length - 1; i >= 0; i--) {
      if (words[i].isBlank()) {
        continue;
      }
      result.append(words[i]).append(" ");
    }
    return result.toString().trim();
  }

  public static void main(String[] args) {
    System.out.println(reverseWords("a good   example"));
  }
}
