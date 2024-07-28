package com.practice.dsa.arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {

  private static final int[] DIRS = {1, 0, -1, 0};
  private static final int[] COL_DIRS = {0, -1, 0, 1};

  record Pair(int row, int col) {

  }

  public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
    int[][] result = image.clone();
    int initialColor = image[sr][sc];

//    dfs(image, result, sr, sc, color, initialColor);
    bfs(image, sr, sc, color, result, initialColor);
    return result;
  }

  private static void bfs(int[][] image, int sr, int sc, int color, int[][] result,
      int initialColor) {
    result[sr][sc] = initialColor;
    Queue<Pair> queue = new LinkedList<>();
    queue.offer(new Pair(sr, sc));

    result[sr][sc] = color;
    while (!queue.isEmpty()) {
      Pair pixelPos = queue.poll();
      int r = pixelPos.row;
      int c = pixelPos.col;

      for (int i = 0; i < 4; i++) {
        int newRow = r + DIRS[i];
        int newCol = c + COL_DIRS[i];

        if (newRow >= 0 && newRow < image.length && newCol >= 0 && newCol < image[0].length
            && image[newRow][newCol] == initialColor) {
          queue.offer(new Pair(newRow, newCol));
          result[newRow][newCol] = color;
        }
      }
    }
  }

  private static void dfs(int[][] image, int[][] result, int sr, int sc, int newColor,
      int initialColor) {
    result[sr][sc] = newColor;
    for (int i = 0; i < 4; i++) {
      int newRow = sr + DIRS[i];
      int newCol = sc + COL_DIRS[i];
      if (newRow >= 0 && newRow < image.length && newCol >= 0 && newCol < image[0].length
          && image[newRow][newCol] == initialColor && result[newRow][newCol] != newColor) {
        dfs(image, result, newRow, newCol, newColor, initialColor);
      }
    }
  }

  public static void main(String[] args) {
    System.out.println(
        Arrays.deepToString(floodFill(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2)));
  }
}
