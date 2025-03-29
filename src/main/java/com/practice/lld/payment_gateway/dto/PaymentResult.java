package com.practice.lld.payment_gateway.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class PaymentResult {
  static class Builder {
    private PaymentStatus paymentStatus;
    private PaymentMethod paymentMethod;
    private Instant processedAt;
    private UUID transactionId;
    private BigDecimal amount;
    private BigDecimal srcBalance;
    private BigDecimal destBalance;

    public Builder setPaymentStatus(PaymentStatus paymentStatus) {
      this.paymentStatus = paymentStatus;
      return this;
    }

    public Builder setPaymentMethod(PaymentMethod paymentMethod) {
      this.paymentMethod = paymentMethod;
      return this;
    }

    public Builder setProcessedAt(Instant processedAt) {
      this.processedAt = processedAt;
      return this;
    }

    public Builder setTransactionId(UUID transactionId) {
      this.transactionId = transactionId;
      return this;
    }

    public Builder setAmount(BigDecimal amount) {
      this.amount = amount;
      return this;
    }

    public Builder setSrcBalance(BigDecimal srcBalance) {
      this.srcBalance = srcBalance;
      return this;
    }

    public Builder setDestBalance(BigDecimal destBalance) {
      this.destBalance = destBalance;
      return this;
    }

    public PaymentResult build() {
      return new PaymentResult(
          paymentStatus,
          paymentMethod,
          processedAt,
          transactionId,
          amount,
          srcBalance,
          destBalance);
    }
  }

  private final PaymentStatus paymentStatus;
  private final PaymentMethod paymentMethod;
  private final Instant processedAt;
  private final UUID transactionId;
  private final BigDecimal amount;
  private final BigDecimal srcBalance;
  private final BigDecimal destBalance;

  public PaymentResult(
      PaymentStatus paymentStatus,
      PaymentMethod paymentMethod,
      Instant processedAt,
      UUID transactionId,
      BigDecimal amount,
      BigDecimal srcBalance,
      BigDecimal destBalance) {
    this.paymentStatus = paymentStatus;
    this.paymentMethod = paymentMethod;
    this.processedAt = processedAt;
    this.transactionId = transactionId;
    this.amount = amount;
    this.srcBalance = srcBalance;
    this.destBalance = destBalance;
  }

  public PaymentStatus getPaymentStatus() {
    return paymentStatus;
  }

  public PaymentMethod getPaymentMethod() {
    return paymentMethod;
  }

  public Instant getProcessedAt() {
    return processedAt;
  }

  public UUID getTransactionId() {
    return transactionId;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public BigDecimal getSrcBalance() {
    return srcBalance;
  }

  public BigDecimal getDestBalance() {
    return destBalance;
  }
}
