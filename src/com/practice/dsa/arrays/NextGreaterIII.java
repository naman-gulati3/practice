package com.practice.dsa.arrays;

public class NextGreaterIII {

  public static int nextGreaterElement(int n) {
    char[] chars = String.valueOf(n).toCharArray();
    if (chars.length == 1) {
      return -1;
    }
    // 4321

    int breakPoint = -1;
    int len = chars.length;
    for (int i = len - 2; i >= 0; i--) {
      if (chars[i] - '0' < chars[i + 1] - '0') {
        breakPoint = i;
        break;
      }
    }

    if (breakPoint == -1) {
      return -1;
    }

    for (int i = len - 1; i > breakPoint; i--) {
      if (chars[i] > chars[breakPoint]) {
        swap(chars, i, breakPoint);
        break;
      }
    }

    reverse(chars, breakPoint + 1, len - 1);

    return Integer.parseInt(new String(chars));
  }

  private static void reverse(char[] chars, int breakPoint, int i) {
    while (breakPoint < i) {
      swap(chars, breakPoint, i);
      breakPoint++;
      i--;
    }
  }

  private static void swap(char[] chars, int i, int j) {
    char temp = chars[i];
    chars[i] = chars[j];
    chars[j] = temp;
  }

  public static void main(String[] args) {
    System.out.println(nextGreaterElement(101));
  }
}
