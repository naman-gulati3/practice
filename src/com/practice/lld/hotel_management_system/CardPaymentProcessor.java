package com.practice.lld.hotel_management_system;

public class CardPaymentProcessor extends PaymentProcessor {

  @Override
  public boolean processPayment(float amount) {
    // integrate with payment gateway
    return true;
  }
}
