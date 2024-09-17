package com.practice.dsa.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraShortestPath {

  record Pair(int node, int weight) {}

  public static List<Integer> shortestPath(int V, int E, int[][] edges) {
    List<List<Pair>> adjList = new ArrayList<>();
    for (int i = 0; i <= V; i++) {
      adjList.add(new ArrayList<>());
    }

    for (int i = 0; i < E; i++) {
      adjList.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
      adjList.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
    }

    PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i.weight));
    int[] distances = new int[V + 1];
    int[] parents = new int[V + 1];
    for (int i = 1; i <= V; i++) {
      distances[i] = Integer.MAX_VALUE;
      parents[i] = i;
    }
    distances[1] = 0;

    pq.offer(new Pair(1, 0));
    while (!pq.isEmpty()) {
      Pair pair = pq.poll();
      int distance = pair.weight;
      int node = pair.node;

      for (Pair adjPair : adjList.get(node)) {
        int adjNode = adjPair.node;
        int edgeWeight = adjPair.weight;

        if (edgeWeight + distance < distances[adjNode]) {
          distances[adjNode] = edgeWeight + distance;
          pq.offer(new Pair(adjNode, edgeWeight + distance));
          parents[adjNode] = node;
        }
      }
    }

    List<Integer> path = new ArrayList<>();
    if (distances[V] == Integer.MAX_VALUE) {
      path.add(-1);
      return path;
    }

    int node = V;
    while (parents[node] != node) {
      path.add(node);
      node = parents[node];
    }
    path.add(1);
    Collections.reverse(path);
    return path;
  }

  public static void main(String[] args) {
    int V = 5, E = 6;

    int[][] edges = {{1, 2, 2}, {2, 5, 5}, {2, 3, 4}, {1, 4, 1}, {4, 3, 3}, {3, 5, 1}};

    List<Integer> path = shortestPath(V, E, edges);
    for (Integer integer : path) {
      System.out.print(integer + " ");
    }
    System.out.println();
  }
}
