package com.practice.priority_queue;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestInArray {

    public static int findKthLargest(int[] nums,
                                     int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            pq.add(num);
        }
        System.out.println(pq);
        while (k - 1 > 0) {
            k--;
            pq.poll();
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4},
                                          2));
    }
    // 1, 2, 3, 4, 5, 6
}
