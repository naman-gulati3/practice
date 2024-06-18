package com.practice.dsa.arrays;

public class MyPow {

  public static void main(String[] args) {
    System.out.println(myPow(2.0, -2147483648));
  }
  private static double myPow(double x, int n) {
    double ans = 1.0;
    long power = n;
    // convert to positive if power is negative
    if(n < 0) {
      power = -1 * power;
    }

    while(power > 0) {
      if(power %2 == 1) {
        ans = ans * x;
        power = power  - 1;
      } else {
        x = x * x;
        power = power / 2;
      }
    }
    if(n < 0) {
      ans = 1.0 / ans;
    }
    return ans;
  }
}
