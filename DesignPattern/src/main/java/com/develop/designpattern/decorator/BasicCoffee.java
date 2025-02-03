package com.develop.designpattern.decorator;

public class BasicCoffee implements Coffee {
    @Override
    public double getCost() {
        return 10;
    }

    @Override
    public String getDescription() {
        return "Basic Coffee";
    }
}
