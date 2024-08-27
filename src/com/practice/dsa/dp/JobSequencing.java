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
    Arrays.fill(dp, -1);

    Job[] jobs = new Job[n];

    for (int i = 0; i < profit.length; i++) {
      jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
    }

    Arrays.sort(jobs, Comparator.comparingInt(j -> j.startTime));

    return solve(0, dp, jobs);
  }

  private static int solve(int i, int[] dp, Job[] jobs) {
    if (i == jobs.length) {
      return 0;
    }

    if (dp[i] != -1) {
      return dp[i];
    }
    // 1, 2, 3, 3
    // 3, 4, 5, 6

    int j = i + 1;
    // find next non overlapping job
    while (j < jobs.length) {
      if (jobs[i].endTime <= jobs[j].startTime) {
        break;
      }
      j++;
    }

    int notTake = solve(i + 1, dp, jobs);
    int take = jobs[i].profit + solve(j, dp, jobs);
    int result = Math.max(notTake, take);
    dp[i] = result;
    return dp[i];
  }


  public static void main(String[] args) {
    System.out.println(
        //                       startTime               endTime                  profit
        jobScheduling(new int[]{1, 2, 3, 3}, new int[]{3, 4, 5, 6}, new int[]{50, 10, 40, 70}));
  }
}
