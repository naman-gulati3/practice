package com.practice.interview_questions;

import java.util.Comparator;

public class StudentNameComparator {

  record Student(String firstName, int age) {}

  static class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
      if (!o1.firstName.equals(o2.firstName)) {
        int comparison = o1.firstName.compareTo(o2.firstName);
        if (comparison != 0) {
          return comparison;
        }
      }
      return Integer.compare(o1.age, o2.age);
    }
  }

  public static void main(String[] args) {
    Student s1 = new Student("Naman", 27);
    Student s2 = new Student("Xyz", 20);
    Student s3 = new Student("Xyz", 18);

    StudentComparator comparator = new StudentComparator();
    System.out.println(comparator.compare(s1, s2));
    System.out.println(comparator.compare(s2, s3));
  }
}
