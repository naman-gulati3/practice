package com.practice.lld.digital_wallet.dto;

import java.util.UUID;

public class User {
  private final String id;
  private final String name;
  private final String email;
  private final String phoneNumber;
  private boolean kycComplete;

  public User(String name, String email, String phoneNumber) {
    this.id = UUID.randomUUID().toString();
    this.name = name;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.kycComplete = false;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public boolean isKycComplete() {
    return kycComplete;
  }

  public void setKycComplete(boolean kycComplete) {
    this.kycComplete = kycComplete;
  }

  public String getId() {
    return id;
  }
}
