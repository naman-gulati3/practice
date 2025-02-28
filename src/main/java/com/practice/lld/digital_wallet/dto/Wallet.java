package com.practice.lld.digital_wallet.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Wallet {
    private  BigDecimal amount;
    private final String userId;
    private final String walletNumber;
    private final BigDecimal walletLimit;
    private final List<Transaction> transactions;

    public Wallet(String userId,
                  String walletNumber,
                  BigDecimal walletLimit) {
        this.userId = userId;
        this.walletNumber = walletNumber;
        this.walletLimit = walletLimit;
        this.transactions = new ArrayList<>();
    }

    public void credit(BigDecimal amount) {
        this.amount = this.amount.add(amount);
    }

    public void debit(BigDecimal amount) {
        this.amount = this.amount.subtract(amount);
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getUserId() {
        return userId;
    }

    public String getWalletNumber() {
        return walletNumber;
    }

    public BigDecimal getWalletLimit() {
        return walletLimit;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }
}
