package com.practice.dsa.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgorithm {

  static class Tuple {

    private final int weight;
    private final int node;

    private final int parent;

    public Tuple(int weight, int adjNode, int parent) {
      this.weight = weight;
      this.node = adjNode;
      this.parent = parent;
    }
  }

  static int spanningTree(int V, int E, List<List<int[]>> adj) {
    int sum = 0;
    PriorityQueue<Tuple> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i.weight));
    List<Integer> parents = new ArrayList<>();
    boolean[] visited = new boolean[V];
    pq.offer(new Tuple(0, 0, 0));

    while (!pq.isEmpty()) {
      Tuple tuple = pq.poll();
      int weight = tuple.weight;
      int node = tuple.node;

      if (visited[node]) {
        continue;
      }
      visited[node] = true;
      sum += weight;
      parents.add(tuple.parent);
      for (int[] neighbour : adj.get(node)) {
        // first index denotes endpoint of edge
        // second index denotes edge weight
        int adjNode = neighbour[0];
        int edgeWeight = neighbour[1];

        if (!visited[adjNode]) {
          pq.offer(new Tuple(edgeWeight, adjNode, node));
        }
      }
    }
    System.out.println(parents);
    return sum;
  }

  public static void main(String[] args) {
    List<List<int[]>> adjList = new ArrayList<>();
    for (int i = 0; i < 3; i++) {
      adjList.add(new ArrayList<>());
    }

    adjList.get(0).add(new int[]{1, 5});
    adjList.get(0).add(new int[]{2, 1});
    adjList.get(1).add(new int[]{2, 3});
    adjList.get(1).add(new int[]{0, 5});
    adjList.get(2).add(new int[]{0, 1});
    adjList.get(2).add(new int[]{1, 3});

    System.out.println(spanningTree(3, 3, adjList));
  }
}
