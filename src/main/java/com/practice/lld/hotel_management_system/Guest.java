package com.practice.lld.hotel_management_system;

public class Guest {

  private final String id;
  private final String name;

  private final long phoneNumber;

  private final String email;

  public Guest(String id, String name, long phoneNumber, String email) {
    this.id = id;
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.email = email;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public long getPhoneNumber() {
    return phoneNumber;
  }

  public String getEmail() {
    return email;
  }
}
