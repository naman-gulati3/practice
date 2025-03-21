package com.practice.dsa.graph;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinCostToConnectPoints {

    // prims algo
    record Pair(int edge, int weight) {}

    public static int minCostConnectPoints(int[][] points) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i.weight));
        int edges = points.length;
        boolean[] visited = new boolean[edges];
        pq.offer(new Pair(0,
                          0));

        int minCost = 0;
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int wt = pair.weight;
            int edge = pair.edge;

            if (visited[edge]) {
                continue;
            }

            visited[edge] = true;
            minCost += wt;

            for (int v = 0; v < edges; v++) {
                if (!visited[v]) {
                    int dist = Math.abs(points[edge][0] - points[v][0]) + Math.abs(points[edge][1] - points[v][1]);
                    pq.offer(new Pair(v,
                                      dist));
                }
            }

        }
        return minCost;
    }

    public static void main(String[] args) {
        System.out.println(minCostConnectPoints(new int[][]{{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}}));
    }

}
