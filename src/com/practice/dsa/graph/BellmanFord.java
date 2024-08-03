package com.practice.dsa.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFord {

  static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
    int[] distances = new int[V];
    Arrays.fill(distances, Integer.MAX_VALUE);
    distances[S] = 0;

    for (int i = 0; i < V - 1; i++) {
      for (ArrayList<Integer> directed : edges) {
        int src = directed.get(0);
        int dest = directed.get(1);
        int weight = directed.get(2);

        if (distances[src] != Integer.MAX_VALUE
            && weight + distances[src] < distances[dest]) {
          distances[dest] = weight + distances[src];
        }
      }
    }

    // Nth relaxation to check for negative cycle

    for (ArrayList<Integer> directed : edges) {
      int node = directed.get(0);
      int neighbour = directed.get(1);
      int weight = directed.get(2);

      if (distances[node] != Integer.MAX_VALUE && weight + distances[node] < distances[neighbour]) {
        int[] temp = new int[1];
        temp[0] = -1;
        return temp;
      }
    }
    return distances;
  }

  public static void main(String[] args) {
    int V = 6;
    int S = 0;
    ArrayList<ArrayList<Integer>> edges = new ArrayList<>() {
      {
        add(new ArrayList<Integer>(Arrays.asList(3, 2, 6)));
        add(new ArrayList<Integer>(Arrays.asList(5, 3, 1)));
        add(new ArrayList<Integer>(Arrays.asList(0, 1, 5)));
        add(new ArrayList<Integer>(Arrays.asList(1, 5, -3)));
        add(new ArrayList<Integer>(Arrays.asList(1, 2, -2)));
        add(new ArrayList<Integer>(Arrays.asList(3, 4, -2)));
        add(new ArrayList<Integer>(Arrays.asList(2, 4, 3)));
      }
    };

    int[] dist = bellman_ford(V, edges, S);
    for (int i = 0; i < V; i++) {
      System.out.print(dist[i] + " ");
    }
    System.out.println();
  }
}
