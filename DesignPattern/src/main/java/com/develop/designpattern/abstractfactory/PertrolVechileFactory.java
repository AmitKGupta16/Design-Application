package com.develop.designpattern.abstractfactory;

public class PertrolVechileFactory implements VechileFactory {
    @Override
    public Car createCar() {
        return new PetrolCar();
    }

    @Override
    public Bike createBike() {
        return new PertrolBike();
    }
}
