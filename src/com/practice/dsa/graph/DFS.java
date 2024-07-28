package com.practice.dsa.graph;

import java.util.ArrayList;
import java.util.List;

public class DFS {

  public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
    boolean[] visited = new boolean[V];
    ArrayList<Integer> dfs = new ArrayList<>();
    dfs(visited, adj, dfs, 0);
    return dfs;
  }

  private static void dfs(boolean[] visited, ArrayList<ArrayList<Integer>> adj,
      ArrayList<Integer> dfs, int node) {

    visited[node] = true;
    dfs.add(node);

    for (Integer neighbor : adj.get(node)) {
      if (!visited[neighbor]) {
        dfs(visited, adj, dfs, neighbor);
      }
    }
  }

  public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
    adjList.add(new ArrayList<>(List.of(2, 3, 1)));
    adjList.add(new ArrayList<>(List.of(0)));
    adjList.add(new ArrayList<>(List.of(0, 4)));
    adjList.add(new ArrayList<>(List.of(0)));
    adjList.add(new ArrayList<>(List.of(2)));
    System.out.println(
        dfsOfGraph(5, adjList));
  }
}
