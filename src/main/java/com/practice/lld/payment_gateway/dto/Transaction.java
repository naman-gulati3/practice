package com.practice.lld.payment_gateway.dto;

import com.practice.lld.payment_gateway.instrument.PaymentInstrument;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class Transaction {
  private UUID id;
  private BigDecimal amount;
  private PaymentInstrument srcPaymentInstrument;
  private PaymentInstrument destPaymentInstrument;
  private Instant processedAt;
  private PaymentMethod paymentMethod;

  public Transaction() {
    this.id = UUID.randomUUID();
  }

  public UUID getId() {
    return id;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public PaymentInstrument getSrcPaymentInstrument() {
    return srcPaymentInstrument;
  }

  public void setSrcPaymentInstrument(PaymentInstrument srcPaymentInstrument) {
    this.srcPaymentInstrument = srcPaymentInstrument;
  }

  public PaymentInstrument getDestPaymentInstrument() {
    return destPaymentInstrument;
  }

  public void setDestPaymentInstrument(PaymentInstrument destPaymentInstrument) {
    this.destPaymentInstrument = destPaymentInstrument;
  }

  public Instant getProcessedAt() {
    return processedAt;
  }

  public void setProcessedAt(Instant processedAt) {
    this.processedAt = processedAt;
  }

  public PaymentMethod getPaymentMethod() {
    return paymentMethod;
  }

  public void setPaymentMethod(PaymentMethod paymentMethod) {
    this.paymentMethod = paymentMethod;
  }
}
