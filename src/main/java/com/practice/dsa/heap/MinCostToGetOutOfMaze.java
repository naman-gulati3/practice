package com.practice.dsa.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinCostToGetOutOfMaze {

  record Cell(int row, int col, int cost) {}

  private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

  public static int minCostToEscape(int[][] maze, int startRow, int startCol) {
    PriorityQueue<Cell> pq = new PriorityQueue<>(Comparator.comparingInt(cell -> cell.cost));
    pq.offer(new Cell(startRow, startCol, maze[startRow][startCol]));

    int[][] minCost = new int[maze.length][maze[0].length];

    for (int[] row : minCost) {
      Arrays.fill(row, Integer.MAX_VALUE);
    }

    minCost[startRow][startCol] = maze[startRow][startCol];

    while (!pq.isEmpty()) {
      Cell cell = pq.poll();
      int row = cell.row;
      int col = cell.col;

      // is a boundary cell
      if (row == 0 || col == 0 || row == maze.length - 1 || col == maze[0].length - 1) {
        return cell.cost;
      }

      for (int[] direction : DIRECTIONS) {
        int newRow = row + direction[0];
        int newCol = col + direction[1];

        if (newRow >= 0
            && newCol >= 0
            && newRow < maze.length
            && col < maze[0].length
            && maze[newRow][newCol] != 0) {

          int cost = cell.cost + maze[newRow][newCol];

          if (cost < minCost[newRow][newCol]) {
            minCost[newRow][newCol] = cost;
            pq.offer(new Cell(newRow, newCol, cost));
          }
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[][] maze = {
      {1, 1, 1, 1},
      {1, 0, 9, 1},
      {1, 1, 9, 1},
      {1, 1, 1, 1}
    };
    int startRow = 1, startCol = 0;
    int result = minCostToEscape(maze, startRow, startCol);
    System.out.println("Minimum cost to escape: " + result); // Output should be 3
  }
}
