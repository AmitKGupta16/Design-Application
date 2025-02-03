package com.develop.designpattern.abstractfactory;

public class PertrolBike implements Bike {
    @Override
    public void assemble() {
        System.out.println("Pertrol Bike assembled");
    }
}
