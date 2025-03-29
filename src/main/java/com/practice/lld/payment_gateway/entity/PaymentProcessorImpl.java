package com.practice.lld.payment_gateway.entity;

import com.practice.lld.payment_gateway.dto.PaymentMethod;
import com.practice.lld.payment_gateway.dto.PaymentRequest;
import com.practice.lld.payment_gateway.dto.PaymentResult;
import com.practice.lld.payment_gateway.service.PaymentProcessor;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class PaymentProcessorImpl implements PaymentProcessor {
  private String accountName;
  private UUID backId;
  private Set<PaymentMethod> supportedPaymentMethod;

  public PaymentProcessorImpl(String accountName, UUID backId) {
    this.accountName = accountName;
    this.backId = backId;
    this.supportedPaymentMethod = new HashSet<>();
  }

  @Override
  public PaymentResult processPayment(PaymentRequest paymentRequest) {
    return null;
  }

  public void setSupportedPaymentMethod(Set<PaymentMethod> supportedPaymentMethod) {
    this.supportedPaymentMethod = supportedPaymentMethod;
  }
}
