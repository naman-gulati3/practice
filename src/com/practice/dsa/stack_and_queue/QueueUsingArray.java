package com.practice.dsa.stack_and_queue;

public class QueueUsingArray {

  class MyQueue {

    int front, rear, count;
    int[] arr = new int[100005];

    MyQueue() {
      front = 0;
      rear = 0;
      count = 0;
    }

    //Function to push an element x in a queue.
    void push(int x) {
      if (count == arr.length) {
        throw new IllegalArgumentException("Queue is full");
      }
      arr[rear % arr.length] = x;
      rear++;
      count++;
    }

    //Function to pop an element from queue and return that element.
    int pop() {
      if (count == 0) {
        //queue is empty
        return -1;
      }

      int elem = front % arr.length;
      arr[front % arr.length] = -1;
      front++;
      count--;
      return elem;
    }
  }
}
