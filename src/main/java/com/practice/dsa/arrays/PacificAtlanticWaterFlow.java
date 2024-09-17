package com.practice.dsa.arrays;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {

  public static List<List<Integer>> pacificAtlantic(int[][] heights) {
    List<List<Integer>> result = new ArrayList<>();
    int m = heights.length;
    int n = heights[0].length;
    boolean[][] pacific = new boolean[m][n];
    boolean[][] atlantic = new boolean[m][n];

    for (int col = 0; col < n; col++) {
      dfs(0, col, pacific, heights[0][col], heights);
      dfs(m - 1, col, atlantic, heights[m - 1][col], heights);
    }

    for (int row = 0; row < m; row++) {
      dfs(row, 0, pacific, heights[row][0], heights);
      dfs(row, n - 1, atlantic, heights[row][n - 1], heights);
    }

    for (int row = 0; row < m; row++) {
      for (int col = 0; col < n; col++) {
        if (pacific[row][col] && atlantic[row][col]) {
          result.add(List.of(row, col));
        }
      }
    }

    return result;
  }

  private static void dfs(int row, int col, boolean[][] visited, int prevHeight, int[][] grid) {
    if (row < 0
        || col < 0
        || row >= grid.length
        || col >= grid[0].length
        || grid[row][col] < prevHeight
        || visited[row][col]) {
      return;
    }
    visited[row][col] = true;
    dfs(row + 1, col, visited, grid[row][col], grid);
    dfs(row - 1, col, visited, grid[row][col], grid);
    dfs(row, col - 1, visited, grid[row][col], grid);
    dfs(row, col + 1, visited, grid[row][col], grid);
  }

  public static void main(String[] args) {
    System.out.println(
        pacificAtlantic(
            new int[][] {
              {1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}
            }));
  }
}
