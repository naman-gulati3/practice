package com.practice.dsa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ValidTreeFromGraph {

  record Pair(int node, int parent) {}

  public boolean validTree(int V, int[][] edges) {
    if (edges.length != V - 1) {
      return false; // A valid tree must have exactly V-1 edges
    }

    List<List<Integer>> adj = new ArrayList<>();
    boolean[] visited = new boolean[V];

    for (int i = 0; i < V; i++) {
      adj.add(new ArrayList<>());
    }

    for (int[] edge : edges) {
      adj.get(edge[0]).add(edge[1]);
      adj.get(edge[1]).add(edge[0]); // Since it's an undirected graph
    }

    if (checkForCycle(adj, 0, visited)) {
      return false;
    }

    for (boolean isVisited : visited) {
      if (!isVisited) {
        return false;
      }
    }

    return true;
  }

  private boolean checkForCycle(List<List<Integer>> adj, int node, boolean[] visited) {
    Queue<Pair> queue = new LinkedList<>();

    queue.offer(new Pair(node, -1));
    visited[node] = true;

    while (!queue.isEmpty()) {
      Pair pair = queue.poll();
      int curr = pair.node;
      int parent = pair.parent;

      for (int neighbor : adj.get(curr)) {
        if (!visited[neighbor]) {
          queue.offer(new Pair(neighbor, curr));
          visited[neighbor] = true;
        } else if (parent != neighbor) {
          return true;
        }
      }
    }

    return false;
  }
}
