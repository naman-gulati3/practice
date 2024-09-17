package com.practice.lld.car_rental_service.payment;

public class CashPaymentProcessor implements PaymentProcessor {

  @Override
  public boolean processPayment(float amount) {
    return true;
  }
}
