package com.develop.designpattern.abstractfactory;

public class ElectricBike implements Bike {
    @Override
    public void assemble() {
        System.out.println("Electric Bike assembled");
    }
}
