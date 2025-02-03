package com.develop.designpattern.factory;

public class Car implements Vechile {
    @Override
    public VechileEnum getType() {
        return VechileEnum.CAR;
    }

}
