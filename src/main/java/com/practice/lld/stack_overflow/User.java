package com.practice.lld.stack_overflow;

public class User {
  private int id;
  private String username;
  private transient char[] password;
  private String email;
  private long reputation;

  public User() {}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public char[] getPassword() {
    return password;
  }

  public void setPassword(char[] password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public long getReputation() {
    return reputation;
  }

  public void setReputation(long reputation) {
    this.reputation = reputation;
  }
}
