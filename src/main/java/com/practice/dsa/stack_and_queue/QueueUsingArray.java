package com.practice.dsa.stack_and_queue;

public class QueueUsingArray {

  static class MyQueue {

    int front, rear, count, capacity;
    int[] arr;

    MyQueue(int capacity) {
      this.capacity = capacity;
      this.arr = new int[capacity];
      front = 0;
      rear = -1;
      count = 0;
    }

    // Function to push an element x in a queue.
    void push(int x) {
      if (count == capacity) {
        return;
      }

      rear = (rear + 1) % capacity;
      arr[rear] = x;
      count++;
    }

    // Function to pop an element from queue and return that element.
    int pop() {
      if (count == 0) {
        // queue is empty
        return -1;
      }

      int popped = arr[front];
      front = (front + 1) % capacity;
      count--;

      return popped;
    }

    int top() {
      if (count == 0) {
        return -1;
      }

      return arr[rear];
    }
  }
}
