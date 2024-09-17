package com.practice.dsa.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class JobSequencing {

  public static class Job {

    int id, profit, deadline;

    Job(int id, int deadline, int profit) {
      this.id = id;
      this.deadline = deadline;
      this.profit = profit;
    }

    @Override
    public String toString() {
      return "Job{" + "id=" + id + ", profit=" + profit + ", deadline=" + deadline + '}';
    }
  }

  public static void main(String[] args) {
    Job[] jobs = new Job[4];
    jobs[0] = new Job(1, 4, 20);
    jobs[1] = new Job(2, 1, 10);
    jobs[2] = new Job(3, 1, 40);
    jobs[3] = new Job(4, 1, 30);
    // 1-40, 1-30, 1-40, 1-10
    System.out.println(Arrays.toString(JobScheduling(jobs, 4)));
  }

  static int[] JobScheduling(Job[] arr, int n) {
    Arrays.sort(arr, (j1, j2) -> j2.profit - j1.profit);
    int maxDeadline =
        Arrays.stream(arr).max(Comparator.comparingInt(j -> j.deadline)).get().deadline;
    int[] result = new int[maxDeadline + 1];

    for (int i = 1; i <= maxDeadline; i++) {
      result[i] = -1;
    }

    int countJobs = 0, jobProfit = 0;
    for (int i = 0; i < n; i++) {
      // try to schedule job as late as possible
      for (int j = arr[i].deadline; j > 0; j--) {
        if (result[j] == -1) {
          result[j] = arr[i].id;
          countJobs++;
          jobProfit += arr[i].profit;
          break;
        }
      }
    }

    int[] res = new int[2];
    res[0] = countJobs;
    res[1] = jobProfit;
    return res;
  }
}
