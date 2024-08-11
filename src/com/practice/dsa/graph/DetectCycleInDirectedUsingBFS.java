package com.practice.dsa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleInDirectedUsingBFS {

  public static boolean isCyclic(int N, List<List<Integer>> adj) {
    int[] inDegree = new int[N + 1];
    for (int i = 0; i < N; i++) {
      for (int node : adj.get(i)) {
        inDegree[node]++;
      }
    }

    return topologicalSort(inDegree, adj, N);
  }

  private static boolean topologicalSort(int[] inDegree, List<List<Integer>> adj, int V) {
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < inDegree.length; i++) {
      if (inDegree[i] == 0) {
        queue.offer(i);
      }
    }

    int i = 0;
    while (!queue.isEmpty()) {
      int curr = queue.poll();
      i++;

      for (int neighbour : adj.get(curr)) {
        inDegree[neighbour]--;

        if (inDegree[neighbour] == 0) {
          queue.offer(neighbour);
        }
      }
    }
    return i != V + 1;
  }

  public static void main(String[] args) {
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < 6; i++) {
      graph.add(new ArrayList<>());
    }
    graph.get(1).add(2);
    graph.get(2).add(3);
    graph.get(3).add(4);
    graph.get(3).add(5);
//    graph.get(4).add(2);

    //  1 ---> 2
    //       / |
    //     /   V
    //   4 <-- 3 ---> 5
    //
    System.out.println(isCyclic(5, graph));
  }
}
