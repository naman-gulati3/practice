package com.practice.lld.payment_gateway.instrument;

import com.practice.lld.payment_gateway.dto.PaymentMethod;

public class UpiInstrument extends PaymentInstrument {
    private String vpa;

    public UpiInstrument() {
        super(PaymentMethod.UPI);
    }

    public String getVpa() {
        return vpa;
    }

    public void setVpa(String vpa) {
        this.vpa = vpa;
    }

}
