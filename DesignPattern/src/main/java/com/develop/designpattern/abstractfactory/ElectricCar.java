package com.develop.designpattern.abstractfactory;

public class ElectricCar implements Car {

    @Override
    public void assemble() {
        System.out.println("Electric Car");
    }
}
