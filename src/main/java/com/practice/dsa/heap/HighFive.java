package com.practice.dsa.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class HighFive {

  public static List<int[]> highFive(int[][] scores) {
    Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
    for (int[] score : scores) {
      int studentId = score[0];
      int studentScore = score[1];

      map.computeIfAbsent(studentId, k -> new PriorityQueue<>()).add(studentScore);

      // if we have more than 5 scores, the top value in min heap will pop out
      // which will end up keeping highest 5 values at the end
      if (map.get(studentId).size() > 5) {
        map.get(studentId).poll();
      }
    }

    List<int[]> result = new ArrayList<>();

    for (var entry : map.entrySet()) {
      int key = entry.getKey();
      var topScores = entry.getValue();

      int scoreSum = 0;

      for (int score : topScores) {
        scoreSum += score;
      }

      int[] r = new int[2];
      r[0] = key;
      r[1] = scoreSum / 5;
      result.add(r);
    }
    return result;
  }

  public static void main(String[] args) {
    highFive(
            new int[][] {
              {1, 91}, {1, 92}, {2, 93}, {2, 97}, {1, 60}, {2, 77}, {1, 65}, {1, 87}, {1, 100},
              {2, 100}, {2, 76}
            })
        .forEach(s -> System.out.println(Arrays.toString(s)));
  }
}
