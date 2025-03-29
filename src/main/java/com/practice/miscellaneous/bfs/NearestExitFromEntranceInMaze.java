package com.practice.miscellaneous.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class NearestExitFromEntranceInMaze {

  private static final int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

  public static void main(String[] args) {
    System.out.println(
        nearestExit(
            new char[][] {{'+', '+', '.', '+'}, {'.', '.', '.', '+'}, {'+', '+', '+', '.'}},
            new int[] {1, 2}));
  }

  record Pair(int row, int col) {}

  public static int nearestExit(char[][] maze, int[] entrance) {
    Queue<Pair> queue = new LinkedList<>();
    queue.offer(new Pair(entrance[0], entrance[1]));
    maze[entrance[0]][entrance[1]] = '+';
    int closestExit = 0;
    while (!queue.isEmpty()) {

      int size = queue.size();

      for (int i = 0; i < size; i++) {
        Pair pair = queue.poll();
        int row = pair.row;
        int col = pair.col;

        if ((row != entrance[0] || col != entrance[1])
            && (row == 0 || col == 0 || row == maze.length - 1 || col == maze[0].length - 1)) {
          return closestExit;
        }
        for (int[] direction : directions) {
          int newRow = row + direction[0];
          int newCol = col + direction[1];

          if (newRow >= 0
              && newCol >= 0
              && newRow < maze.length
              && newCol < maze[0].length
              && maze[newRow][newCol] != '+') {
            maze[newRow][newCol] = '+';
            queue.offer(new Pair(newRow, newCol));
          }
        }
      }
      closestExit++;
    }

    return -1;
  }
}
