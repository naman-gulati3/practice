package com.practice.dsa.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumMultiplicationToReachEnd {

  static class Pair {

    private final int adjNode;
    private final int steps;

    public Pair(int adjNode, int steps) {
      this.adjNode = adjNode;
      this.steps = steps;
    }
  }

  static int minimumMultiplications(int[] arr, int start, int end) {
    int[] steps = new int[100000];
    Arrays.fill(steps, Integer.MAX_VALUE);
    steps[start] = 0;
    Queue<Pair> queue = new LinkedList<>();
    queue.offer(new Pair(start, 0));
    int mod = 100000;

    while (!queue.isEmpty()) {
      Pair pair = queue.poll();
      int adjNode = pair.adjNode;
      int stepsCount = pair.steps;

      for (int i : arr) {
        int num = (i * adjNode) % mod;
        if (stepsCount + 1 < steps[num]) {
          steps[num] = stepsCount + 1;
          if (num == end) {
            return stepsCount + 1;
          }
          queue.offer(new Pair(num, stepsCount + 1));
        }
      }
    }
    return steps[end] == Integer.MAX_VALUE ? -1 : steps[end];
  }

  public static void main(String[] args) {
    System.out.println(minimumMultiplications(new int[] {9, 12, 18, 19}, 5, 15390));
  }
}
