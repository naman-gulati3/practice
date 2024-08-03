package com.practice.dsa.graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

  private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  record Pair(int row, int col) {

  }

  public static int numIslands(char[][] grid) {
    int count = 0;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1') {
          dfs(i, j, grid);
          count++;
        }
      }
    }

    return count;
  }

  private static void dfs(int row, int col, char[][] grid) {
    if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length
        || grid[row][col] != '1') {
      return;
    }

    // mark with some character otherwise dfs will run infinitely
    grid[row][col] = '0';
    dfs(row + 1, col, grid); // down
    dfs(row - 1, col, grid); // up
    dfs(row, col - 1, grid); // left
    dfs(row, col + 1, grid); // right
  }

  private static void bfs(int row, int col, boolean[][] visited, char[][] grid) {
    visited[row][col] = true;
    Queue<Pair> queue = new LinkedList<>();
    queue.offer(new Pair(row, col));

    while (!queue.isEmpty()) {
      Pair pair = queue.poll();
      int currRow = pair.row();
      int currCol = pair.col();

      for (int[] dir : DIRECTIONS) {
        int neighbourRow = currRow + dir[0];
        int neighbourCol = currCol + dir[1];

        if (isValid(neighbourRow, neighbourCol, grid) && grid[neighbourRow][neighbourCol] == '1'
            && !visited[neighbourRow][neighbourCol]) {
          visited[neighbourRow][neighbourCol] = true;
          queue.offer(new Pair(neighbourRow, neighbourCol));
        }
      }
    }
  }

  private static boolean isValid(int row, int col, char[][] grid) {
    return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
  }


  public static void main(String[] args) {
    char[][] grid = {
        {'1', '1', '0', '0', '0'},
        {'1', '1', '0', '0', '0'},
        {'0', '0', '1', '0', '0'},
        {'0', '0', '0', '1', '1'}
    };

    // 3
    System.out.println(numIslands(grid));
  }
}
