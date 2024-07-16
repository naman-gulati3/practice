package com.practice.dsa.stack_and_queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {

  // 1,2,3,4,5, k = 2
  //
  public static int[] maxSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    Deque<Integer> queue = new ArrayDeque<>();
    int[] result = new int[n - k + 1];
    int l = 0;
    int r = 0;
    while (r < n) {
      // if queue is overflowed. Trim down window
      if (!queue.isEmpty() && queue.peekFirst() == r - k) {
        queue.poll();
      }
      // queue should be in only decreasing order. Poll last until decreasing order is maintained
      while (!queue.isEmpty() && nums[queue.peekLast()] < nums[r]) {
        queue.pollLast();
      }
      queue.offer(r);

      // start storing result once we have 1 complete window
      if (r >= k - 1) {
        // peek first because queue is in decreasing order
        result[l++] = nums[queue.peekFirst()];
      }
      r++;
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    System.out.println(Arrays.toString(maxSlidingWindow(new int[]{7, 2, 3}, 2)));
  }
}
