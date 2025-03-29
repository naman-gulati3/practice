package com.practice.lld.digital_wallet.service;

import com.practice.lld.digital_wallet.dto.User;
import com.practice.lld.digital_wallet.dto.Wallet;

public interface WalletService {

  Wallet createWallet(User user);
}
