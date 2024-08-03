package com.practice.dsa.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TopologicalSortDFS {

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

  public static int[] topologicalSort(int V, List<List<Integer>> graph) {
    boolean[] visited = new boolean[V + 1];
    Stack<Integer> stack = new Stack<>();
    int[] sorted = new int[V + 1];

    for (int i = 0; i < V; i++) {
      if (!visited[i]) {
        topoSort(stack, visited, i, graph);
      }
    }
    int i = 0;
    while (!stack.isEmpty()) {
      sorted[i++] = stack.pop();
    }
    return sorted;
  }

  private static void topoSort(Stack<Integer> stack, boolean[] visited, int node,
      List<List<Integer>> graph) {
    visited[node] = true;
    for (int neighbour : graph.get(node)) {
      if (!visited[neighbour]) {
        topoSort(stack, visited, neighbour, graph);
      }
    }
    stack.push(node);
  }
}
