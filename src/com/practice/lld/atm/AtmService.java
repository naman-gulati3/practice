package com.practice.lld.atm;

public interface AtmService {

  void withdraw(String accountNumber, float amount);

  float  checkBalance(String accountNumber);

  void deposit(String accountNumber, float amount);

}
