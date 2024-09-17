package com.practice.dsa.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {

  static class Pair {

    private final int distance;
    private final int node;

    public Pair(int distance, int node) {
      this.distance = distance;
      this.node = node;
    }
  }

  static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
    int[] distances = new int[V];
    PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.distance));

    Arrays.fill(distances, Integer.MAX_VALUE);

    distances[S] = 0;
    pq.offer(new Pair(0, S));

    while (!pq.isEmpty()) {
      Pair pair = pq.poll();
      int distance = pair.distance;
      int node = pair.node;

      for (int i = 0; i < adj.get(node).size(); i++) {
        int edgeWeight = adj.get(node).get(i).get(1);
        int neighbour = adj.get(node).get(i).get(0);

        if (edgeWeight + distance < distances[neighbour]) {
          distances[neighbour] = edgeWeight + distance;
          pq.offer(new Pair(edgeWeight + distance, neighbour));
        }
      }
    }
    return distances;
  }

  public static void main(String[] args) {
    int V = 3;
    ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      adj.add(new ArrayList<>());
    }

    adj.get(0).add(new ArrayList<>(List.of(1, 1)));
    adj.get(0).add(new ArrayList<>(List.of(2, 6)));

    adj.get(1).add(new ArrayList<>(List.of(0, 1)));
    adj.get(1).add(new ArrayList<>(List.of(2, 3)));

    adj.get(2).add(new ArrayList<>(List.of(0, 6)));
    adj.get(2).add(new ArrayList<>(List.of(1, 3)));

    System.out.println(Arrays.toString(dijkstra(V, adj, 2)));
  }
}
