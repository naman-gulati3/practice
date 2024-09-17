package com.practice.dsa.graph;

import java.util.ArrayList;

public class DetectCycleUsingDFS {

  public static void main(String[] args) {

    {
      ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
      for (int i = 0; i < 5; i++) {
        adj.add(new ArrayList<>());
      }
      adj.get(0).add(1);
      adj.get(1).add(0);
      adj.get(1).add(2);
      adj.get(2).add(1);
      adj.get(2).add(3);
      adj.get(3).add(2);
      adj.get(3).add(4);
      adj.get(4).add(3);
      adj.get(4).add(0); // Adding a cycle for testing
      adj.get(0).add(4);

      System.out.println(isCycle(5, adj));
    }
  }

  private static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
    boolean[] visited = new boolean[V];

    // this loop is required to check each component which could be disconnected from each other
    for (int i = 0; i < V; i++) {
      if (!visited[i]) {
        if (checkForCycle(i, -1, visited, adj)) {
          return true;
        }
      }
    }
    return false;
  }

  private static boolean checkForCycle(
      int node, int parent, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
    vis[node] = true;
    // go to all adjacent nodes
    for (int adjacentNode : adj.get(node)) {
      if (!vis[adjacentNode]) {
        if (checkForCycle(adjacentNode, node, vis, adj)) {
          return true;
        }
      }
      // if adjacent node is visited and is not its own parent node
      else if (adjacentNode != parent) {
        return true;
      }
    }
    return false;
  }
}
