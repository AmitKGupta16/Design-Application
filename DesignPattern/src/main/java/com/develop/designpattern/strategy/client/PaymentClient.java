package com.develop.designpattern.strategy.client;

import com.develop.designpattern.strategy.CreditCardPaymentStrategy;
import com.develop.designpattern.strategy.PaymentContext;

public class PaymentClient {
    public static void main(String[] args) throws Exception {
        PaymentContext context = new PaymentContext();
        context.setPaymentStrategy(new CreditCardPaymentStrategy("22323"));
        context.execute(456);
    }
}
