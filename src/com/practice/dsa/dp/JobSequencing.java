package com.practice.dsa.dp;

import java.util.Arrays;
import java.util.Comparator;

public class JobSequencing {

  static class Job {

    int startTime, endTime, profit;

    Job(int startTime, int endTime, int profit) {
      this.startTime = startTime;
      this.endTime = endTime;
      this.profit = profit;
    }
  }

  public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
    int n = startTime.length;
    int[] dp = new int[n + 1];

    Job[] jobs = new Job[n];

    for (int i = 0; i < profit.length; i++) {
      jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
    }

    Arrays.sort(jobs, Comparator.comparingInt(j -> j.endTime));

    Arrays.fill(dp, -1);

    for (int i = 0; i < n; i++) {
      int jobEndTime = jobs[i].endTime;
      int jobStartTime = jobs[i].startTime;
      int jobProfit = jobs[i].profit;

      int latestNonConflictingJob = upperBound(jobs, i, jobStartTime);
      dp[i + 1] = Math.max(dp[i], dp[latestNonConflictingJob] + jobProfit);
    }
    return dp[n];
  }

  private static int upperBound(Job[] jobs, int end, int target) {
    int low = 0;
    int high = end;
    while (low < high) {
      int mid = (low + high) / 2;
      if (jobs[mid].endTime <= target) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return low;
  }

  public static void main(String[] args) {
    System.out.println(
        jobScheduling(new int[]{1, 2, 3, 3}, new int[]{3, 4, 5, 6}, new int[]{50, 10, 40, 70}));
  }
}
