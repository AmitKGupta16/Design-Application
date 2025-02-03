package com.develop.designpattern.abstractfactory.client;

import com.develop.designpattern.abstractfactory.*;

public class AbstractFactoryClient {
    public static void main(String[] args) {
       VechileFactory factory =  FactoryProducer.getVechileFactory("electric");
       Bike bike = factory.createBike();
       Car car = factory.createCar();

       bike.assemble();
       car.assemble();
    }
}
