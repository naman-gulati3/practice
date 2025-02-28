package com.practice.lld.digital_wallet.service;

import com.practice.lld.digital_wallet.dto.Wallet;

import java.math.BigDecimal;

public class PaymentProcessorImpl
        implements PaymentProcessor {

    @Override
    public void transferCreditToWallet(Wallet destWallet,
                                       BigDecimal amount) {

    }

    @Override
    public void transferP2p(Wallet srcWallet,
                            Wallet destWallet,
                            BigDecimal amount) {

    }

}
