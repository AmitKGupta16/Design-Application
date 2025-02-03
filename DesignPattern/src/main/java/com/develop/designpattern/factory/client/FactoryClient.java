package com.develop.designpattern.factory.client;

import com.develop.designpattern.factory.VechileEnum;
import com.develop.designpattern.factory.VechileFactory;

public class FactoryClient {
    public static void main(String[] args) {
        System.out.println(VechileFactory.createVechileFactory(VechileEnum.BUS).getType().name());
    }
}
