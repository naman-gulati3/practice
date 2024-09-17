package com.practice.dsa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

  public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
    boolean[] visited = new boolean[V];
    Queue<Integer> queue = new LinkedList<>();
    ArrayList<Integer> bfs = new ArrayList<>();
    queue.offer(0);
    visited[0] = true;

    while (!queue.isEmpty()) {
      int node = queue.poll();
      bfs.add(node);

      for (Integer neighbor : adj.get(node)) {
        if (!visited[neighbor]) {
          visited[neighbor] = true;
          queue.offer(neighbor);
        }
      }
    }
    return bfs;
  }

  public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
    var e1 = new ArrayList<>(List.of(1, 2, 3));
    var e2 = new ArrayList<>(List.of(4));

    adjList.add(e1);
    adjList.add(new ArrayList<>());
    adjList.add(e2);
    adjList.add(new ArrayList<>());
    adjList.add(new ArrayList<>());
    System.out.println(bfsOfGraph(5, adjList));
  }
}
