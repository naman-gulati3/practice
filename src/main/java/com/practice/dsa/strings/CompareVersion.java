package com.practice.dsa.strings;

public class CompareVersion {

  public static int compareVersion(String version1, String version2) {
    String[] v1 = version1.split("\\.");
    String[] v2 = version2.split("\\.");

    for (int i = 0; i < Math.max(v1.length, v2.length); i++) {
      int nums1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
      int nums2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;

      if (nums1 < nums2) {
        return -1;
      }
      if (nums1 > nums2) {
        return 1;
      }
    }
    return 0;
  }

  public static void main(String[] args) {
    System.out.println(compareVersion("1.0", "1.0.0.0"));
  }
}
