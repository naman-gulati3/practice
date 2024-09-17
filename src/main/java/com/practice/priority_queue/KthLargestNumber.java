package com.practice.priority_queue;

import java.util.PriorityQueue;

public class KthLargestNumber {

  static class KthLargest {

    private PriorityQueue<Integer> pq;
    private int k;

    public KthLargest(int k, int[] nums) {
      this.k = k;
      this.pq = new PriorityQueue<>();
      for (int num : nums) {
        pq.add(num);
      }
    }

    public int add(int val) {
      pq.add(val);
      while (pq.size() > k) {
        pq.poll();
      }
      return pq.peek();
    }
  }

  public static void main(String[] args) {
    var kthLargest = new KthLargest(3, new int[] {4, 5, 8, 2});
    System.out.println(kthLargest.add(3)); // return 4
    System.out.println(kthLargest.add(5)); // return 5
    System.out.println(kthLargest.add(10)); // return 5
    System.out.println(kthLargest.add(9)); // return 8
    System.out.println(kthLargest.add(4)); // return 8
  }
}
