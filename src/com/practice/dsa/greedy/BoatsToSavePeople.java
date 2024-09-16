package com.practice.dsa.greedy;

import java.util.Arrays;

public class BoatsToSavePeople {

  public static int numRescueBoats(int[] people, int limit) {

    Arrays.sort(people);

    int i = 0;
    int j = people.length - 1;
    int count = 0;

    while (i <= j) {
      if (i == j) {
        count++;
        break;
      }
      if (people[i] + people[j] > limit) {
        count++;
        j--;
      } else {
        if (people[j] == limit) {
          count++;
          j--;
        } else {
          count++;
          i++;
          j--;
        }
      }
    }

    return count;
    // 1, 2, 2, 3
    // 3, 3, 4, 5
  }

  public static void main(String[] args) {
    System.out.println(numRescueBoats(new int[]{1, 2}, 3));
  }
}
