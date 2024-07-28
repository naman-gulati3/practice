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
      this.maxQueue.offer(num);
      if (!maxQueue.isEmpty() && !minQueue.isEmpty() && maxQueue.peek() > minQueue.peek()) {
        minQueue.offer(maxQueue.poll());
      }

      if (maxQueue.size() - 1 > minQueue.size()) {
        minQueue.offer(maxQueue.poll());
      }

      if (minQueue.size() - 1 > maxQueue.size()) {
        maxQueue.offer(minQueue.poll());
      }
    }

    public double findMedian() {
      if (maxQueue.isEmpty()) {
        return -1;
      }

      int count = this.maxQueue.size() + this.minQueue.size();
      if (count % 2 == 0) {
        if (this.minQueue.isEmpty()) {
          return maxQueue.peek();
        }

        return (double) (this.maxQueue.peek() + this.minQueue.peek()) / 2;
      } else {
        if (this.maxQueue.size() > this.minQueue.size()) {
          return (double) this.maxQueue.peek();
        } else {
          return this.minQueue.peek();
        }
      }
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
