package com.practice.interview_questions;

import java.util.Arrays;

public class ThreadSafeBlockingQueue {
  public static class BlockingQueue<T> {
    private static final Object lock = new Object();
    private int putIdx;
    private int takeIdx;
    private int count;
    private final int capacity;
    private final Object[] items;

    public BlockingQueue(int capacity) {
      this.capacity = capacity;
      this.items = new Object[capacity];
    }

    public void offer(T item) throws InterruptedException {
      synchronized (lock) {
        // wait till queue is not full
        while (count == items.length) {
          lock.wait();
        }

        putIdx = (putIdx + 1) % capacity;
        items[putIdx] = item;
        count++;

        lock.notifyAll();
      }
    }

    public T take() throws InterruptedException {
      synchronized (lock) {
        // wait till queue is not empty
        while (count == 0) {
          lock.wait();
        }

        T item = (T) items[takeIdx];
        items[takeIdx] = null;
        takeIdx = (takeIdx + 1) % capacity;
        count--;
        lock.notifyAll();
        return item;
      }
    }
  }

  public static void main(String[] args) throws InterruptedException {
    BlockingQueue<Integer> blockingQueue = new BlockingQueue<>(10);
    Thread t1 =
        new Thread(
            () -> {
              for (int i = 1; i <= 10; i++) {
                try {
                  blockingQueue.offer(i);
                } catch (InterruptedException e) {
                  throw new RuntimeException(e);
                }
              }
              try {
                Thread.sleep(100L);
                System.out.println(Arrays.toString(blockingQueue.items));
              } catch (InterruptedException e) {
                throw new RuntimeException(e);
              }
            });

    Thread t2 =
        new Thread(
            () -> {
              try {
                System.out.println(blockingQueue.take());
                System.out.println(blockingQueue.take());
              } catch (InterruptedException e) {
                throw new RuntimeException(e);
              }
            });

    t1.start();
    t2.start();
  }
}
