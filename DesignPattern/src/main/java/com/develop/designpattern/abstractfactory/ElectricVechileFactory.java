package com.develop.designpattern.abstractfactory;

public class ElectricVechileFactory implements VechileFactory {
    @Override
    public Car createCar() {
        return new ElectricCar();
    }

    @Override
    public Bike createBike() {
        return new ElectricBike();
    }
}
