package com.practice.lld.digital_wallet.service;

import com.practice.lld.digital_wallet.dto.Wallet;
import java.math.BigDecimal;

public interface PaymentProcessor {
  void transferCreditToWallet(Wallet destWallet, BigDecimal amount);

  void transferP2p(Wallet srcWallet, Wallet destWallet, BigDecimal amount);
}
