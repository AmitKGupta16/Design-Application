package com.develop.designpattern.factory;

public class VechileFactory {
    public static Vechile createVechileFactory(VechileEnum type) {
        Vechile vechile = null;
        if (type == VechileEnum.CAR) {
            vechile = new Car();
        } else if (type == VechileEnum.BUS) {
            vechile = new Bus();
        }
        return vechile;
    }
}
