package com.practice.dsa.binary_search;

public class NthRoot {

  public static void main(String[] args) {
    System.out.println(NthRoot(3, 27));
    System.out.println(NthRoot2(3, 27));
  }

  public static int NthRoot(int n, int m) {
    double low = 1;
    double high = m;
    double eps = 1e-6;

    while (high - low > eps) {
      double mid = (high + low) / 2.0;

      double ans = 1.0;
      for (int i = 0; i < n; i++) {
        ans = ans * mid;
      }

      if (Math.abs(ans - m) < eps) {
        return (int) mid;
      }

      if (ans > m) {
        high = mid;
      } else {
        low = mid;
      }

      int potentialRoot = (int) Math.round((high + low) / 2);
      double check = 1.0;

      for (int i = 0; i < n; i++) {
        check *= potentialRoot;
      }

      if (Math.abs(check - m) < eps) {
        return potentialRoot;
      }
    }
    return -1;
  }

  public static int NthRoot2(int n, int m) {
    int low = 1;
    int high = m;

    while (low < high) {
      int mid = (low + high) / 2;
      int potentialRoot = getPotentialRoot(mid, n, m);
      if (potentialRoot == 0) {
        return mid;
      } else if (potentialRoot == 2) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return -1;
  }

  private static int getPotentialRoot(int mid, int n, int m) {
    int ans = 1;
    for (int i = 1; i <= n; i++) {
      ans *= mid;
    }
    if (ans == m) {
      return 0;
    } else if (ans > mid) {
      return 2;
    }
    return 1;
  }
}
