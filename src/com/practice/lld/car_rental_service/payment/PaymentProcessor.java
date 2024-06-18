package com.practice.lld.car_rental_service.payment;

public interface PaymentProcessor {
  boolean processPayment(float amount);
}
