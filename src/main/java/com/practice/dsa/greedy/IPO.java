package com.practice.dsa.greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class IPO {

  record Pair(int profit, int capital) {}

  public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    List<Pair> pairs = new ArrayList<>();

    for (int i = 0; i < capital.length; i++) {
      pairs.add(new Pair(profits[i], capital[i]));
    }

    pairs.sort(Comparator.comparingInt(p -> p.capital));
    int totalProfit = w;
    int j = 0;

    for (int i = 0; i < k; i++) {
      while (j < capital.length && pairs.get(j).capital <= totalProfit) {
        pq.offer(pairs.get(j).profit);
        j++;
      }
      if (pq.isEmpty()) {
        break;
      }

      totalProfit += pq.poll();
    }

    return totalProfit;
  }

  public static void main(String[] args) {
    System.out.println(findMaximizedCapital(2, 0, new int[] {1, 2, 3}, new int[] {0, 1, 1}));
  }
}
