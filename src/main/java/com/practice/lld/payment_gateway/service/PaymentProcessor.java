package com.practice.lld.payment_gateway.service;

import com.practice.lld.payment_gateway.dto.PaymentRequest;
import com.practice.lld.payment_gateway.dto.PaymentResult;

public interface PaymentProcessor {
    PaymentResult processPayment(PaymentRequest paymentRequest);
}
