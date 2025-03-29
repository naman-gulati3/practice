package com.practice.dsa.greedy;

public class JumpGameII {

  public static int jump(int[] nums) {
    int l = 0;
    int r = 0;
    int jumps = 0;

    while (r < nums.length - 1) {
      int farthest = 0;
      for (int i = l; i <= r; i++) {
        farthest = Math.max(farthest, i + nums[i]);
      }
      l = r + 1;
      r = farthest;

      jumps += 1;
    }
    return jumps;
  }

  public static void main(String[] args) {
    System.out.println(jump(new int[] {2, 3, 1, 1, 4}));
  }
}
