package com.develop.designpattern.decorator;

public class SugarCoffee extends CoffeeDecorator {
    public SugarCoffee(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Sugar Coffee";
    }
    @Override
    public double getCost() {
        return super.getCost() + 0.2;
    }
}
