package com.practice.dsa.binary_search;

import java.util.Arrays;

public class AllocateBooks {

  public static int books(int[] books, int studentsCount) {
    int n = books.length;
    if (studentsCount > n) {
      return -1;
    }
    // worst case when studentsCount = n
    int low = Arrays.stream(books).max().getAsInt();
    // worst case when studentsCount is 1
    int high = Arrays.stream(books).sum();

    while (low <= high) {
      int mid = (low + high) / 2;
      int students = countStudents(books, mid);
      if (students > studentsCount) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return low;
  }

  private static int countStudents(int[] books, int pages) {
    int n = books.length;
    int students = 1;
    int pagesPerStudent = 0;
    for (int i = 0; i < n; i++) {
      if (pagesPerStudent + books[i] <= pages) {
        pagesPerStudent += books[i];
      } else {
        students++;
        pagesPerStudent = books[i];
      }
    }
    return students;
  }

  public static void main(String[] args) {
    System.out.println(books(new int[]{12, 34, 67, 90}, 3));
  }
}
