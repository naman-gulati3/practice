package com.practice.interview_questions;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class CustomPalindromeIterator implements Iterator<String> {

  private final List<String> names;

  private int size;

  public CustomPalindromeIterator(List<String> names) {
    this.names = names.stream().filter(this::isPalindrome).collect(Collectors.toList());
    this.size = this.names.size();
  }

  private boolean isPalindrome(String s) {
    int i = 0;
    int j = s.length() - 1;

    while (i < j) {
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }

  @Override
  public boolean hasNext() {
    return this.size > 0;
  }

  @Override
  public String next() {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    this.size--;
    return this.names.get(size);
  }

  public static void main(String[] args) {
    List<String> names = List.of("naman", "aaa", "xyz", "naman", "aaa");
    var iterator = new CustomPalindromeIterator(names);
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }
}
