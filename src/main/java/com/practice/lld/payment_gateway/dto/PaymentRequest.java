package com.practice.lld.payment_gateway.dto;

import com.practice.lld.payment_gateway.instrument.PaymentInstrument;

import java.math.BigDecimal;

public class PaymentRequest {
    private final PaymentMethod paymentMethod;
    private final BigDecimal amount;
    private final PaymentInstrument sourcePaymentInstrument;
    private final PaymentInstrument destPaymentInstrument;

    public PaymentRequest(PaymentMethod paymentMethod,
                          BigDecimal amount,
                          PaymentInstrument sourcePaymentInstrument,
                          PaymentInstrument destPaymentInstrument) {
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.sourcePaymentInstrument = sourcePaymentInstrument;
        this.destPaymentInstrument = destPaymentInstrument;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public PaymentInstrument getSourcePaymentInstrument() {
        return sourcePaymentInstrument;
    }

    public PaymentInstrument getDestPaymentInstrument() {
        return destPaymentInstrument;
    }

}
