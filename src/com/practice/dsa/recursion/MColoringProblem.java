package com.practice.dsa.recursion;

public class MColoringProblem {

  public static void main(String[] args) {
    boolean[][] graph = new boolean[5][4];
    graph[0][1] = true;
    graph[1][0] = true;

    graph[1][2] = true;
    graph[2][1] = true;

    graph[2][3] = true;
    graph[3][2] = true;

    graph[3][0] = true;
    graph[0][3] = true;

    graph[0][2] = true;
    graph[2][0] = true;
    System.out.println(graphColoring(graph, 3, 5));
  }

  public static boolean graphColoring(boolean[][] graph, int m, int n) {
    int[] colors = new int[m - 1];
    return false;
//    return solve(0, graph, colors, n, m);
  }

//  private static boolean solve(int node, boolean[][] graph, int[] colors, int n, int m) {
//    if (node == n) {
//      return true;
//    }
//
//    for (int i = 0; i < m; i++) {
//      if (isSafe(node, graph, colors, n, i)) {
//
//      }
//    }
//  }
}
