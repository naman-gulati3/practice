package com.practice.priority_queue;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFromStream {

  static class MedianFinder {

    private PriorityQueue<Integer> maxQueue;
    private PriorityQueue<Integer> minQueue;

    public MedianFinder() {
      this.maxQueue = new PriorityQueue<>(Collections.reverseOrder());
      this.minQueue = new PriorityQueue<>();
    }

    public void addNum(int num) {
      if (maxQueue.isEmpty() || maxQueue.peek() >= num) {
        maxQueue.offer(num);
      } else {
        minQueue.offer(num);
      }

      if (maxQueue.size() > minQueue.size() + 1) {
        minQueue.offer(maxQueue.poll());
      } else if (maxQueue.size() < minQueue.size()) {
        maxQueue.offer(minQueue.poll());
      }
    }

    public double findMedian() {
      if (!maxQueue.isEmpty() && !minQueue.isEmpty() && maxQueue.size() == minQueue.size()) {
        return (double) (maxQueue.peek() + minQueue.peek()) / 2.0;
      }

      return maxQueue.isEmpty() ? -1 : maxQueue.peek();
    }
  }

  public static void main(String[] args) {
    MedianFinder medianFinder = new MedianFinder();
    medianFinder.addNum(1);
    System.out.println(medianFinder.findMedian());
    medianFinder.addNum(2);
    System.out.println(medianFinder.findMedian());
    medianFinder.addNum(3);
    System.out.println(medianFinder.findMedian());
    medianFinder.addNum(4);
    System.out.println(medianFinder.findMedian());
    medianFinder.addNum(5);
    System.out.println(medianFinder.findMedian());
    medianFinder.addNum(6);
    System.out.println(medianFinder.findMedian());
    medianFinder.addNum(7);
    System.out.println(medianFinder.findMedian());
    medianFinder.addNum(8);
    System.out.println(medianFinder.findMedian());
    medianFinder.addNum(9);
    System.out.println(medianFinder.findMedian());
    medianFinder.addNum(10);
    System.out.println(medianFinder.findMedian());
  }
}
