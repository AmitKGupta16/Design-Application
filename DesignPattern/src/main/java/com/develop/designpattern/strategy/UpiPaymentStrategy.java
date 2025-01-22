package com.develop.designpattern.strategy;

public class UpiPaymentStrategy implements PaymentStrategy {
    private String mobile;
    public UpiPaymentStrategy(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public void pay(double amount) {
        System.out.println("UpiPaymentStrategy: paying " + amount + " to " + mobile);
    }
}
