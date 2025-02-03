package com.develop.designpattern.factory;

public enum VechileEnum {
    CAR("CAR","Car"), BIKE("BIKE","Bike"), BUS("BUS","Bus");
    private VechileEnum(String name, String value) {
        this.value = value;
    }
    public final String value;

}
