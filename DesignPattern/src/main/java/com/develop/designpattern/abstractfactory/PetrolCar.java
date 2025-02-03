package com.develop.designpattern.abstractfactory;

public class PetrolCar implements Car {

    @Override
    public void assemble() {
        System.out.println("Petrol Car");
    }
}
