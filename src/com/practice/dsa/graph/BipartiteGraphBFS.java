package com.practice.dsa.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraphBFS {

  public static boolean isBipartite(int[][] graph) {
    int[] color = new int[graph.length];
    Arrays.fill(color, -1);
    int V = graph.length;

    for (int i = 0; i < V; i++) {
      if (color[i] == -1) {
        if (!check(color, i, graph)) {
          return false;
        }
      }
    }
    return true;
  }

  private static boolean check(int[] color, int start, int[][] graph) {
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(start);
    color[start] = 1;

    while (!queue.isEmpty()) {
      int node = queue.poll();
      for (int neighbour : graph[node]) {
        if (color[neighbour] == -1) {
          color[neighbour] = 1 - color[node];
          queue.offer(neighbour);
        } else if (color[neighbour] == color[node]) {
          return false;
        }
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
