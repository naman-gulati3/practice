package com.practice.dsa.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StronglyConnectedComponents {

  public static void main(String[] args) {
    int n = 5;
    int[][] edges = {
      {1, 0}, {0, 2},
      {2, 1}, {0, 3},
      {3, 4}
    };
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<>());
    }
    for (int i = 0; i < n; i++) {
      adj.get(edges[i][0]).add(edges[i][1]);
    }
    System.out.println(kosaraju(n, adj));
  }

  public static int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
    boolean[] visited = new boolean[V];
    Stack<Integer> stack = new Stack<>();
    // topological sort starts
    for (int i = 0; i < V; i++) {
      if (!visited[i]) {
        dfs(visited, i, stack, adj);
      }
    }
    // topological sort ends

    // transpose graph, if edge i -> it change it to it -> i
    List<List<Integer>> transposedAdjList = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      transposedAdjList.add(new ArrayList<>());
    }

    for (int i = 0; i < V; i++) {
      visited[i] = false;

      for (int node : adj.get(i)) {
        transposedAdjList.get(node).add(i);
      }
    }

    int stronglyConnectedComponent = 0;

    while (!stack.isEmpty()) {
      int node = stack.pop();
      if (!visited[node]) {
        stronglyConnectedComponent++;
        reverseDfs(node, transposedAdjList, visited);
      }
    }
    return stronglyConnectedComponent;
  }

  private static void reverseDfs(
      int node, List<List<Integer>> transposedAdjList, boolean[] visited) {
    visited[node] = true;
    for (int neighbour : transposedAdjList.get(node)) {
      if (!visited[neighbour]) {
        reverseDfs(neighbour, transposedAdjList, visited);
      }
    }
  }

  private static void dfs(
      boolean[] visited, int start, Stack<Integer> stack, ArrayList<ArrayList<Integer>> adj) {
    visited[start] = true;
    for (int neighbour : adj.get(start)) {
      if (!visited[neighbour]) {
        dfs(visited, neighbour, stack, adj);
      }
    }

    stack.push(start);
  }
}
