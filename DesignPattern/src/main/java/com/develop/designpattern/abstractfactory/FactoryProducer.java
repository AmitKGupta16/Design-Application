package com.develop.designpattern.abstractfactory;

public class FactoryProducer {
    public static VechileFactory getVechileFactory(String vechileType) {
        if("electric".equalsIgnoreCase(vechileType)) {
            return  new ElectricVechileFactory();
        }else if("petrol".equalsIgnoreCase(vechileType)) {
            return new PertrolVechileFactory();
        }
        throw new IllegalArgumentException("Unknown vechileType: " + vechileType);
    }
}
