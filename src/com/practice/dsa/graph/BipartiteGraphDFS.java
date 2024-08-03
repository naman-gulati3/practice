package com.practice.dsa.graph;

import java.util.Arrays;

public class BipartiteGraphDFS {

  public static boolean isBipartite(int[][] graph) {
    int V = graph.length;
    int[] color = new int[V];
    Arrays.fill(color, -1);

    for (int i = 0; i < V; i++) {
      if (color[i] == -1) {
        if (!dfs(color, i, graph, 0)) {
          return false;
        }
      }
    }

    return true;
  }

  private static boolean dfs(int[] colors, int node, int[][] graph, int color) {
    colors[node] = color;
    for (int neighbour : graph[node]) {
      if (colors[neighbour] == -1) {
        if (!dfs(colors, neighbour, graph, 1 - color)) {
          return false;
        }
      } else if (colors[neighbour] == colors[node]) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    int[][] adjList = new int[10][10];
    adjList[0] = new int[]{};
    adjList[1] = new int[]{2, 4, 6};
    adjList[2] = new int[]{1, 4, 8, 9};
    adjList[3] = new int[]{7, 8};
    adjList[4] = new int[]{1, 2, 8, 9};
    adjList[5] = new int[]{6, 9};
    adjList[6] = new int[]{1, 5, 7, 8, 9};
    adjList[7] = new int[]{3, 6, 9};
    adjList[8] = new int[]{2, 3, 4, 6, 9};
    adjList[9] = new int[]{2, 4, 5, 6, 7, 8};

    System.out.println(isBipartite(adjList));
  }

}
