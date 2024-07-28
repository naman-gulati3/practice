package com.practice.dsa.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CheckIfCourseCanBeCompleted {

  public static boolean canFinish(int numCourses, int[][] prerequisites) {
    // build a graph
    var graph = new HashMap<Integer, ArrayList<Integer>>();
    for (int[] prerequisite : prerequisites) {
      var from = prerequisite[0];
      var to = prerequisite[1];

      graph.computeIfAbsent(from, (k) -> new ArrayList<>());
      graph.computeIfAbsent(to, (k) -> new ArrayList<>());

      graph.get(from).add(to);
    }

    // DFS
    var visited = new HashSet<Integer>();
    for (Map.Entry<Integer, ArrayList<Integer>> entry : graph.entrySet()) {
      var fromNode = entry.getKey();
      if (canNotFinishCourse(graph, fromNode, visited)) {
        return false;
      }
    }
    return true;
  }

  public static boolean canNotFinishCourse(HashMap<Integer, ArrayList<Integer>> graph, Integer curr,
      Set<Integer> visited) {
    if (visited.contains(curr)) {
      return true; // Detected a loop! return false
    }

    if (graph.get(curr).isEmpty()) {
      return false; // Reached the end
    }

    visited.add(curr);

    for (var neighbor : graph.get(curr)) {
      if (canNotFinishCourse(graph, neighbor, visited)) {
        return true;
      }
    }

    visited.remove(curr);
    graph.put(curr, new ArrayList<>());

    return false;
  }

  public static void main(String[] args) {
    int[][] prerequisites = new int[][]{{1, 0}, {0, 1}};

    System.out.println(canFinish(2, prerequisites));
  }
}
