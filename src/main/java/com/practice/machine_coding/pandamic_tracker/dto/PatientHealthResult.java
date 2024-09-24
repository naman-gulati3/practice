package com.practice.machine_coding.pandamic_tracker.dto;

public class PatientHealthResult {

  private final Admin admin;
  private final String phoneNumber;
  private final int pinCode;
  private final boolean isRecovered;
  private final String name;

  public PatientHealthResult(Admin admin, String name, String phoneNumber, int pinCode,
      boolean isRecovered) {
    this.phoneNumber = phoneNumber;
    this.name = name;
    this.admin = admin;
    this.pinCode = pinCode;
    this.isRecovered = isRecovered;
  }

  public Admin getAdmin() {
    return admin;
  }

  public String getName() {
    return name;
  }

  public int getPinCode() {
    return pinCode;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public boolean isRecovered() {
    return isRecovered;
  }
}
