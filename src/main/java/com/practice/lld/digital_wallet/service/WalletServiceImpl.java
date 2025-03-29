package com.practice.lld.digital_wallet.service;

import com.practice.lld.digital_wallet.dto.User;
import com.practice.lld.digital_wallet.dto.Wallet;
import java.math.BigDecimal;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class WalletServiceImpl implements WalletService {

  private final Map<String, Wallet> wallets;

  public WalletServiceImpl() {
    this.wallets = new ConcurrentHashMap<>();
  }

  @Override
  public Wallet createWallet(User user) {
    Wallet wallet =
        new Wallet(user.getId(), UUID.randomUUID().toString(), BigDecimal.valueOf(1000.0));
    wallets.put(wallet.getWalletNumber(), wallet);
    return wallet;
  }
}
