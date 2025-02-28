package com.practice.interview_questions;

import java.util.concurrent.Semaphore;

public class MultiThreadedSequencePrint {

    // Shared counter to ensure numbers are printed in order
    private static int counter = 1;
    private static final int MAX_COUNT = 100;
    // Lock object for synchronization
    private static final Semaphore lock = new Semaphore(1);

    public static void main(String[] args) {
        int numThreads = 5;
        Thread[] threads = new Thread[numThreads];

        // Create and start threads
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(new CounterTask());
            threads[i].start();
        }

        // Wait for all threads to complete
        for (int i = 0; i < numThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class CounterTask
            implements Runnable {

        @Override
        public void run() {
            try {
                while (true) {
                    lock.acquire();
                    // Check if we've reached the maximum count
                    if (counter > MAX_COUNT) {
                        lock.release();
                        break;
                    }

                    // Print the current number with the thread name
                    System.out.println(counter++);
                    lock.release();

                    // Optionally add a small delay to make thread switching more visible
                    // try {
                    //     Thread.sleep(50);
                    // } catch (InterruptedException e) {
                    //     e.printStackTrace();
                    // }
                }

                // Yield to allow other threads to execute
                Thread.yield();
            } catch (Exception e) {
                //
            }
        }

    }

}
