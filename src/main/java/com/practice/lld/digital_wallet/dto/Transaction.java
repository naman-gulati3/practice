package com.practice.lld.digital_wallet.dto;

import java.math.BigDecimal;
import java.time.Instant;

public class Transaction {
  private final BigDecimal bigDecimal;
  private final String srcWalletNumber;
  private final String destWalletNumber;
  private final Instant processedAt;
  private TransactionStatus transactionStatus;

  public Transaction(
      BigDecimal bigDecimal, String srcWalletNumber, String destWalletNumber, Instant processedAt) {
    this.bigDecimal = bigDecimal;
    this.srcWalletNumber = srcWalletNumber;
    this.destWalletNumber = destWalletNumber;
    this.processedAt = processedAt;
    this.transactionStatus = TransactionStatus.PENDING;
  }

  public TransactionStatus getTransactionStatus() {
    return transactionStatus;
  }

  public void setTransactionStatus(TransactionStatus transactionStatus) {
    this.transactionStatus = transactionStatus;
  }

  public BigDecimal getBigDecimal() {
    return bigDecimal;
  }

  public String getSrcWalletNumber() {
    return srcWalletNumber;
  }

  public String getDestWalletNumber() {
    return destWalletNumber;
  }

  public Instant getProcessedAt() {
    return processedAt;
  }
}
