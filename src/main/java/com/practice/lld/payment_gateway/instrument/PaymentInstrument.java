package com.practice.lld.payment_gateway.instrument;

import com.practice.lld.payment_gateway.dto.PaymentMethod;

public abstract class PaymentInstrument {
    private PaymentMethod paymentMethod;

    public PaymentInstrument(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }
}
