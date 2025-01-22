package com.develop.designpattern.strategy;

public class CreditCardPaymentStrategy implements PaymentStrategy {

    private String cardNumber;

    public CreditCardPaymentStrategy(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("You have paid " + amount + " credit card :" + cardNumber );
    }
}
