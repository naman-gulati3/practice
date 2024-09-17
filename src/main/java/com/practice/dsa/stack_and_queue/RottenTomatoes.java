package com.practice.dsa.stack_and_queue;

import java.util.LinkedList;
import java.util.Queue;

public class RottenTomatoes {

  record Pair(int row, int col) {}

  public static void main(String[] args) {
    // 2, 1, 1
    // 0, 1, 1
    // 1, 0, 1
    System.out.println(orangesRotting(new int[][] {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}));
  }

  public static int orangesRotting(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    int freshCount = 0;
    Queue<Pair> rottenTomatoesLocation = new LinkedList<>();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 2) {
          rottenTomatoesLocation.offer(new Pair(i, j));
        } else if (grid[i][j] == 1) {
          freshCount++;
        }
      }
    }

    if (freshCount == 0) {
      return 0;
    }

    int count = 0;
    int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    while (!rottenTomatoesLocation.isEmpty()) {
      count++;

      int rottenTomatoesSize = rottenTomatoesLocation.size();
      for (int i = 0; i < rottenTomatoesSize; i++) {
        Pair location = rottenTomatoesLocation.poll();
        for (int[] direction : directions) {
          int row = location.row + direction[0];
          int col = location.col + direction[1];

          if (row >= n
              || col >= m
              || row < 0
              || col < 0
              || grid[row][col] == 2
              || grid[row][col] == 0) {
            continue;
          }

          grid[row][col] = 2;
          freshCount--;
          rottenTomatoesLocation.offer(new Pair(row, col));
        }
      }
    }
    return freshCount == 0 ? count - 1 : -1;
  }
}
