package com.practice.dsa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleUsingBFS {

  record Pair(int node, int parent) {

  }

  public static void main(String[] args) {

    {
      ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
      for (int i = 0; i < 4; i++) {
        adj.add(new ArrayList<>());
      }
      adj.get(1).add(2);
      adj.get(2).add(1);
      adj.get(2).add(3);
      adj.get(3).add(2);
      // 1 ---- 2
      //        |
      //        3
      System.out.println(isCycle(4, adj));
    }
  }

  private static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
    boolean[] visited = new boolean[V];

    // this for loop is for cases when we have multiple disconnected components
    for (int i = 0; i < V; i++) {
      if (!visited[i]) {
        if (checkForCycle(visited, adj, i)) {
          return true;
        }
      }
    }
    return false;
  }

  private static boolean checkForCycle(boolean[] visited, ArrayList<ArrayList<Integer>> adj,
      int node) {
    Queue<Pair> queue = new LinkedList<>();
    queue.offer(new Pair(node, -1));

    while (!queue.isEmpty()) {
      Pair pair = queue.poll();
      int curr = pair.node;
      int parent = pair.parent;

      for (int neighbour : adj.get(curr)) {
        if (!visited[neighbour]) {
          queue.offer(new Pair(neighbour, curr));
          visited[neighbour] = true;
        } else if (parent != neighbour) {
          return true;
        }
      }
    }
    return false;
  }
}
