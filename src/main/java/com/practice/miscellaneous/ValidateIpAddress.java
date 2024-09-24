package com.practice.miscellaneous;

public class ValidateIpAddress {

  public static String validIPAddress(String queryIP) {
    String[] splitOnDot = queryIP.split("\\.");
    if (splitOnDot.length == 4) {
      return checkForIpV4(splitOnDot);
    }

    String[] splitOnColon = queryIP.split(":");
    if (splitOnColon.length == 8) {
      return checkForIpV6(splitOnColon);
    }

    return "Neither";
  }

  private static String checkForIpV4(String[] split) {
    for (int i = 0; i < split.length; i++) {
      if (split[i].length() > 1 && split[i].startsWith("0")) {
        return "Neither";
      }

      int section = Integer.parseInt(split[i]);
      if (section > 255) {
        return "Neither";
      }
    }

    return "IPv4";
  }

  private static String checkForIpV6(String[] split) {
    for (int i = 0; i < split.length; i++) {
      if (split[i].isBlank()) {
        return "Neither";
      }
      char[] ch = split[i].toCharArray();
      for (int j = 0; j < ch.length; j++) {

        if (Character.isAlphabetic(ch[j])) {
          if (ch[j] >= 'a' && ch[j] <= 'z' && ch[j] > 'f') {
            return "Neither";
          }

          if (ch[j] >= 'A' && ch[j] <= 'Z' && ch[j] > 'F') {
            return "Neither";
          }
        }
      }
    }

    return "IPv6";
  }

  public static void main(String[] args) {
    System.out.println(validIPAddress("172.16.254.1"));
    System.out.println(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
  }
}
