package com.practice.dsa.stack_and_queue;

public class QueueUsingArray {

  static class MyQueue {

    int front, rear, count, capacity;
    int[] arr;

    MyQueue(int capacity) {
      this.capacity = capacity;
      this.arr = new int[capacity];
      front = 0;
      rear = 0;
      count = 0;
    }

    // Function to push an element x in a queue.
    void push(int x) {
      if (count == capacity) {
        throw new IllegalArgumentException("Capacity is full");
      }
      if (rear == -1) {
        front = 0;
        rear = 0;
      } else {
        rear = (rear + 1) % capacity;
        arr[rear] = x;
        count++;
      }
    }

    // Function to pop an element from queue and return that element.
    int pop() {
      if (front == -1) {
        // queue is empty
        throw new IllegalArgumentException("Queue is empty");
      }

      int popped = arr[front];
      if (count == 1) {
        front = -1;
        rear = -1;
      } else {
        front = (front + 1) % capacity;
        count--;
      }
      return popped;
    }

    int top() {
      if (front == -1) {
        return -1;
      }

      return arr[rear];
    }
  }
}
