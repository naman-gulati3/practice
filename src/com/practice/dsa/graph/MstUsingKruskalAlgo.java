package com.practice.dsa.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MstUsingKruskalAlgo {

  static class DisjointSet {

    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n) {
      for (int i = 0; i <= n; i++) {
        // parent of i is i itself
        rank.add(0);
        parent.add(i);
        size.add(1);
      }
    }

    public int findUltimateParent(int node) {
      if (node == parent.get(node)) {
        return node;
      }

      int ultimateParent = findUltimateParent(parent.get(node));
      parent.set(node, ultimateParent);
      return parent.get(node);
    }

    public void unionByRank(int u, int v) {
      int ultimateUParent = findUltimateParent(u);
      int ultimateVParent = findUltimateParent(v);

      if (ultimateUParent == ultimateVParent) {
        return;
      }

      if (rank.get(ultimateUParent) < rank.get(ultimateVParent)) {
        parent.set(ultimateUParent, ultimateVParent);
      } else if (rank.get(ultimateUParent) > rank.get(ultimateVParent)) {
        parent.set(ultimateVParent, ultimateUParent);
      } else {
        parent.set(ultimateVParent, ultimateUParent);
        int rankU = rank.get(ultimateUParent);
        rank.set(ultimateUParent, rankU + 1);
      }
    }

    public void unionBySize(int u, int v) {
      int ultimateUParent = findUltimateParent(u);
      int ultimateVParent = findUltimateParent(v);

      if (ultimateUParent == ultimateVParent) {
        return;
      }

      if (size.get(ultimateUParent) < size.get(ultimateVParent)) {
        parent.set(ultimateUParent, ultimateVParent);
      } else if (size.get(ultimateUParent) > size.get(ultimateVParent)) {
        parent.set(ultimateVParent, ultimateUParent);
      } else {
        parent.set(ultimateVParent, ultimateUParent);
        size.set(ultimateUParent, size.get(ultimateUParent) + size.get(ultimateVParent));
      }
    }
  }

  static class Edge {

    private final int weight;
    private final int src;
    private final int dest;

    public Edge(int weight, int src, int dest) {
      this.weight = weight;
      this.src = src;
      this.dest = dest;
    }
  }

  static int spanningTree(int V, List<List<List<Integer>>> adj) {
    List<Edge> edges = new ArrayList<>();

    for (int i = 0; i < V; i++) {
      for (int j = 0; j < adj.get(i).size(); j++) {
        int adjNode = adj.get(i).get(j).get(0);
        int weight = adj.get(i).get(j).get(1);

        if (i < adjNode) { // To prevent adding both directions of the edge
          edges.add(new Edge(i, adjNode, weight));
        }
      }
    }

    DisjointSet ds = new DisjointSet(V);
    edges.sort(Comparator.comparingInt(e -> e.weight));
    int mstWeight = 0;
    for (Edge edge : edges) {
      int source = edge.src;
      int destination = edge.dest;
      int weight = edge.weight;

      if (ds.findUltimateParent(source) != ds.findUltimateParent(destination)) {
        mstWeight += weight;
        ds.unionBySize(source, destination);
      }
    }

    return mstWeight;
  }

  public static void main(String[] args) {
    int V = 5;
    List<List<List<Integer>>> adj = new ArrayList<>();
    int[][] edges = {{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}};

    for (int i = 0; i < V; i++) {
      adj.add(new ArrayList<>());
    }

    for (int i = 0; i < 6; i++) {
      int u = edges[i][0];
      int v = edges[i][1];
      int w = edges[i][2];

      ArrayList<Integer> tmp1 = new ArrayList<>();
      ArrayList<Integer> tmp2 = new ArrayList<>();
      tmp1.add(v);
      tmp1.add(w);

      tmp2.add(u);
      tmp2.add(w);

      adj.get(u).add(tmp1);
      adj.get(v).add(tmp2);
    }

    System.out.println(adj);

    int mstWt = spanningTree(V, adj);
    System.out.println("The sum of all the edge weights: " + mstWt);
  }
}
