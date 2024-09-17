package com.practice.miscellaneous;

public class CelebrityProblem {

  public static void main(String[] args) {
    int n = 4;
    int[][] matrix = {{0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}, {0, 0, 1, 0}};
    int id = findCelebrity(n, matrix);
    if (id == -1) {
      System.out.println("No celebrity");
    } else {
      System.out.println("Celebrity ID " + id);
    }
  }

  static boolean knows(int person1, int person2, int[][] matrix) {
    return matrix[person1][person2] == 1;
  }

  static int findCelebrity(int n, int[][] matrix) {
    int[] inDegree = new int[n];
    int[] outDegree = new int[n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int knows = knows(i, j, matrix) ? 1 : 0;

        outDegree[i] += knows;
        inDegree[j] += knows;
      }
    }

    for (int i = 0; i < n; i++) {
      if (inDegree[i] == n - 1 && outDegree[i] == 0) {
        return i;
      }
    }
    return -1;
  }
}
