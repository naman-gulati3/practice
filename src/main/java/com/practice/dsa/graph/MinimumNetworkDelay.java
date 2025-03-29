package com.practice.dsa.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumNetworkDelay {

  record Pair(int dest, int time) {}

  public static int networkDelayTime(int[][] times, int n, int k) {
    List<List<Pair>> adjList = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      adjList.add(new ArrayList<>());
    }

    for (int[] time : times) {
      adjList.get(time[0]).add(new Pair(time[1], time[2]));
    }

    PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(pair -> pair.time));
    int[] delays = new int[n + 1];
    Arrays.fill(delays, Integer.MAX_VALUE);
    delays[k] = 0;
    pq.offer(new Pair(k, 0));

    while (!pq.isEmpty()) {
      Pair pair = pq.poll();
      int node = pair.dest;
      int weight = pair.time;

      for (Pair adjPair : adjList.get(node)) {
        int adjNode = adjPair.dest;
        int adjWeight = adjPair.time;

        if (adjWeight + weight < delays[adjNode]) {
          delays[adjNode] = adjWeight + weight;
          pq.offer(new Pair(adjNode, adjWeight + weight));
        }
      }
    }

    int max = 0;
    for (int i = 1; i < n + 1; i++) {
      if (delays[i] == Integer.MAX_VALUE) {
        return -1;
      }

      max = Math.max(max, delays[i]);
    }

    return max;
  }

  public static void main(String[] args) {
    System.out.println(networkDelayTime(new int[][] {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2));
  }
}
