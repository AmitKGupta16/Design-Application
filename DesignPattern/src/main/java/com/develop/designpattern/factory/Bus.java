package com.develop.designpattern.factory;

public class Bus implements Vechile{

    @Override
    public VechileEnum getType() {
        return VechileEnum.BUS;
    }

}
