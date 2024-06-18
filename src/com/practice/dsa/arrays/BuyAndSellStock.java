package com.practice.dsa.arrays;

import java.util.Arrays;

public class BuyAndSellStock {

  public static void main(String[] args) {
    // best time to buy index 1, best time to sell index 4 = 5
    System.out.println(maxProfit(new int[]{7,1,5,3,4,6}));
    System.out.println(maxProfitKadaneAlgo(new int[]{7,1,5,3,4,6}));
    // 7,1,5,3,4,6
    // 7, 1, 1, 1, 1, 1
    // 7, 6, 6, 6, 6, 4
  }

  public static int maxProfit(int[] prices) {
    int[] prefixMin = new int[prices.length];
    int[] suffixMax = new int[prices.length];
    prefixMin[0] = prices[0];
    suffixMax[prices.length - 1] = prices[prices.length - 1];
    for(int i = 1; i < prices.length; i++) {
      if(prices[i] > prefixMin[i - 1]) {
        prefixMin[i] = prefixMin[i - 1];
      } else {
        prefixMin[i] = prices[i];
      }
    }

    for(int i = prices.length - 2; i >= 0; i--) {
      if(prices[i] > suffixMax[i + 1]) {
        suffixMax[i] = prices[i];
      } else {
        suffixMax[i] = suffixMax[i + 1];
      }
    }

    int max = 0;
    for(int i = 0; i < prices.length; i++) {
      max = Math.max(max, suffixMax[i] - prefixMin[i]);
    }
    return max;
  }

  public static int maxProfitKadaneAlgo(int[] prices) {
    int profit = 0;
    int buy = prices[0];
    for (int i = 1; i < prices.length; i++) {
      if(prices[i] < buy) {
        buy = prices[i];
      } else if (prices[i] - buy > profit) {
        profit = prices[i] - buy;
      }
    }
    return profit;
  }
}
