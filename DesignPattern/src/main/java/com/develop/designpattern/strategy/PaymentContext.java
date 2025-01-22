package com.develop.designpattern.strategy;

import lombok.Setter;

@Setter
public class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public void execute(double amount) throws Exception {
        if(paymentStrategy == null) {
            throw new Exception("Payment strategy is not set");
        }
        paymentStrategy.pay(amount);
    }

}
