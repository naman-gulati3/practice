package com.practice.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class RatInMaze {

  public static void main(String[] args) {
    System.out.println(findPath(new int[][]{{1, 0, 0, 0},
        {1, 1, 0, 1},
        {1, 1, 0, 0},
        {0, 1, 1, 1}}, 4));
//    System.out.println(findPath(new int[][]{{1, 1}, {1, 1}}, 2));
  }

  public static List<String> findPath(int[][] m, int n) {
    List<String> result = new ArrayList<>();
    int[] idirections = new int[]{1, 0, 0, -1};
    int[] jdirections = new int[]{0, -1, 1, 0};

    if (m[0][0] != 1) {
      return result;
    }

    boolean[][] visited = new boolean[n][n];
    visited[0][0] = true;

    solve(0, 0, m, n, result, "", visited, idirections, jdirections);
//    solve2(0, 0, m, n, result, "", new boolean[n][n]);
    return result;
  }

  private static void solve2(int i, int j, int[][] m, int n, List<String> result, String moves,
      boolean[][] visited) {
    if (i == n - 1 && j == n - 1) {
      result.add(moves);
      return;
    }

    // downwards
    if (i + 1 < n && !visited[i + 1][j] && m[i + 1][j] == 1) {
      visited[i + 1][j] = true;
      solve2(i + 1, j, m, n, result, moves + "D", visited);
      visited[i + 1][j] = false;
    }

    // upwards
    if (i - 1 >= 0 && !visited[i - 1][j] && m[i - 1][j] == 1) {
      visited[i - 1][j] = true;
      solve2(i - 1, j, m, n, result, moves + "U", visited);
      visited[i - 1][j] = false;
    }

    // left
    if (j - 1 >= 0 && !visited[i][j - 1] && m[i][j - 1] == 1) {
      visited[i][j - 1] = true;
      solve2(i, j - 1, m, n, result, moves + "L", visited);
      visited[i][j - 1] = false;
    }

    // right
    if (j + 1 < n && !visited[i][j + 1] && m[i][j + 1] == 1) {
      visited[i][j + 1] = true;
      solve2(i, j + 1, m, n, result, moves + "R", visited);
      visited[i][j + 1] = false;
    }
  }

  private static void solve(int i, int j, int[][] m, int n, List<String> result,
      String moves,
      boolean[][] visited, int[] idirections, int[] jdirections) {
    if (i == n - 1 && j == n - 1) {
      result.add(moves);
      return;
    }

    String dir = "DLRU";
    for (int idx = 0; idx < 4; idx++) {
      int nexti = i + idirections[idx];
      int nextj = j + jdirections[idx];

      if (nexti >= 0 && nextj >= 0 && nexti < n && nextj < n && !visited[nexti][nextj]
          && m[nexti][nextj] == 1) {
        visited[i][j] = true;
        solve(nexti, nextj, m, n, result, moves + dir.charAt(idx), visited, idirections,
            jdirections);
        visited[i][j] = false;
      }
    }
  }
}
