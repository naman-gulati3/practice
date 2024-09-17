package com.practice.dsa.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSortBFS {

  public static void main(String[] args) {
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < 6; i++) {
      graph.add(new ArrayList<>());
    }
    graph.get(1).add(2);
    graph.get(2).add(3);
    graph.get(3).add(4);
    graph.get(3).add(5);

    System.out.println(Arrays.toString(topologicalSort(5, graph)));
  }

  private static int[] topologicalSort(int V, List<List<Integer>> graph) {
    int[] inDegree = new int[V + 1];
    for (int i = 0; i < V; i++) {
      for (int node : graph.get(i)) {
        inDegree[node]++;
      }
    }

    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < V; i++) {
      if (inDegree[i] == 0) {
        queue.offer(i);
      }
    }

    int[] sorted = new int[V + 1];
    int i = 0;
    while (!queue.isEmpty()) {
      int node = queue.poll();
      sorted[i++] = node;

      for (int neighbour : graph.get(node)) {
        inDegree[neighbour]--;

        if (inDegree[neighbour] == 0) {
          queue.offer(neighbour);
        }
      }
    }
    return sorted;
  }
}
