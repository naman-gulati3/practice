package com.practice.dsa.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

  static class Node {

    public int val;
    public List<Node> neighbors;

    public Node() {
      val = 0;
      neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
      val = _val;
      neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
      val = _val;
      neighbors = _neighbors;
    }
  }

  public static Node cloneGraph(Node node) {
    Map<Node, Node> map = new HashMap<>();
    return cloneUtil(map, node);
  }

  private static Node cloneUtil(Map<Node, Node> map, Node node) {
    if (node == null) {
      return null;
    }
    if (map.containsKey(node)) {
      return map.get(node);
    }

    Node clone = new Node(node.val);
    map.put(node, clone);
    for (Node neighbour : node.neighbors) {
      clone.neighbors.add(cloneUtil(map, neighbour));
    }
    return clone;
  }

  public static void main(String[] args) {
    Node node = new Node(1);
    Node node2 = new Node(2);
    Node node3 = new Node(3);
    Node node4 = new Node(4);

    node.neighbors = List.of(node2, node3);
    node2.neighbors = List.of(node, node3);
    node3.neighbors = List.of(node2, node4);
    node4.neighbors = List.of(node, node3);

    Node cloned = cloneGraph(node);
    System.out.println(cloned);
  }
}
