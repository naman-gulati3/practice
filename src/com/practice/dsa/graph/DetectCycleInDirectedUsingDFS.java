package com.practice.dsa.graph;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleInDirectedUsingDFS {

  public static boolean isCyclic(int N, List<List<Integer>> adj) {
    boolean[] visited = new boolean[N + 1];
    boolean[] dfsVisited = new boolean[N + 1];

    for (int i = 1; i <= N; i++) {
      if (!visited[i]) {
        if (dfs(i, visited, dfsVisited, adj)) {
          return true;
        }
      }
    }
    return false;
  }

  private static boolean dfs(int node, boolean[] visited, boolean[] dfsVisited,
      List<List<Integer>> adj) {
    visited[node] = true;
    dfsVisited[node] = true;

    for (int neighbour : adj.get(node)) {
      if (!visited[neighbour]) {
        if (dfs(neighbour, visited, dfsVisited, adj)) {
          return true;
        }
      } else if (dfsVisited[neighbour]) {
        return true;
      }
    }
    dfsVisited[node] = false;
    return false;
  }

  public static void main(String[] args) {
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < 6; i++) {
      graph.add(new ArrayList<>());
    }
    graph.get(1).add(2);
    graph.get(2).add(3);
    graph.get(3).add(4);
    graph.get(3).add(5);
    graph.get(4).add(2);

    //  1 ---> 2
    //         |
    //         V
    //   4 <-- 3 ---> 5
    //
    System.out.println(isCyclic(5, graph));
  }
}
