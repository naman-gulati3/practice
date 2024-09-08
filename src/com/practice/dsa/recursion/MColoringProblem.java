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
    System.out.println(graphColoring(graph, 3, 4));
  }

  public static boolean graphColoring(boolean[][] graph, int m, int V) {
    int[] colors = new int[V];
    return solve(0, graph, colors, V, m);
  }

  private static boolean solve(int node, boolean[][] graph, int[] colors, int V, int m) {
    // all nodes are coloured
    if (node == V) {
      return true;
    }

    for (int color = 1; color <= m; color++) {
      if (isSafe(node, graph, colors, V, color)) {
        colors[node] = color;
      }

      if (solve(node + 1, graph, colors, V, m)) {
        return true;
      }

      colors[node] = 0;
    }

    return false;
  }

  private static boolean isSafe(int node, boolean[][] graph, int[] colors, int V, int color) {
    for (int i = 0; i < V; i++) {
      if (graph[node][i] && colors[i] == color) {
        return false;
      }
    }

    return true;
  }
}
