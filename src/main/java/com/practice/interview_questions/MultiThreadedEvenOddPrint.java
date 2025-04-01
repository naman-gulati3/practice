package com.practice.interview_questions;

import java.util.concurrent.Semaphore;

public class MultiThreadedEvenOddPrint {

  private static int counter = 1;
  private static final int MAX_NUM = 1000;
  private static final Semaphore evenLock = new Semaphore(1);
  private static final Semaphore oddLock = new Semaphore(0);

  static class NumPrinter implements Runnable {

    private final boolean isEven;

    public NumPrinter(boolean isEven) {
      this.isEven = isEven;
    }

    @Override
    public void run() {
      while (true) {
        try {
          if (isEven) {
            evenLock.acquire();
          } else {
            oddLock.acquire();
          }

          if (counter > MAX_NUM) {
            oddLock.release();
            evenLock.release();
            break;
          }

          System.out.println(counter++);
          if (isEven) {
            // signal odd lock to release its lock for next iteration
            oddLock.release();
          } else {
            evenLock.release();
          }

        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    }
  }

  public static void main(String[] args) throws InterruptedException {
    var t1 = new Thread(() -> new NumPrinter(true).run(), "even");
    var t2 = new Thread(() -> new NumPrinter(false).run(), "odd");
    t1.start();
    t2.start();
    t1.join();
    t2.join();
  }
}
