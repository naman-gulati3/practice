package com.practice.dsa.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CheckIfCourseCanBeCompleted {

  public static boolean canFinish(int numCourses, int[][] prerequisites) {
    // build a graph
    var graph = new HashMap<Integer, ArrayList<Integer>>();
    for (int[] prerequisite : prerequisites) {
      var from = prerequisite[0];
      var to = prerequisite[1];

      graph.computeIfAbsent(from, (k) -> new ArrayList<>()).add(to);
    }

    // DFS
    var visited = new HashSet<Integer>();
    for (Map.Entry<Integer, ArrayList<Integer>> entry : graph.entrySet()) {
      Integer fromNode = entry.getKey();
      if (canNotFinishCourse(graph, fromNode, visited)) {
        return false;
      }
    }
    return true;
  }

  public static boolean canNotFinishCourse(
      HashMap<Integer, ArrayList<Integer>> graph, Integer curr, Set<Integer> visited) {
    if (visited.contains(curr)) {
      return true; // Detected a loop! return true
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

  public static boolean canFinishTopoSort(int numCourses, int[][] prerequisites) {
    // create a graph
    List<List<Integer>> adjList = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) {
      adjList.add(new ArrayList<>());
    }

    int E = prerequisites.length;
    for (int i = 0; i < E; i++) {
      adjList.get(prerequisites[i][0]).add(prerequisites[i][1]);
    }

    int[] indegrees = new int[numCourses];
    for (int i = 0; i < numCourses; i++) {
      for (int node : adjList.get(i)) {
        indegrees[node]++;
      }
    }

    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
      if (indegrees[i] == 0) {
        queue.offer(i);
      }
    }

    List<Integer> topoSort = new ArrayList<>();

    while (!queue.isEmpty()) {
      int node = queue.poll();
      topoSort.add(node);

      for (int neighbour : adjList.get(node)) {
        indegrees[neighbour]--;
        if (indegrees[neighbour] == 0) {
          queue.offer(neighbour);
        }
      }
    }

    return topoSort.size() == numCourses;
  }

  public static void main(String[] args) {
    int[][] prerequisites = new int[][] {{1, 0}};

    System.out.println(canFinishTopoSort(2, prerequisites));
  }
}
