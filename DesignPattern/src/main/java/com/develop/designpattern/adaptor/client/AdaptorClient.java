package com.develop.designpattern.adaptor.client;

import com.develop.designpattern.adaptor.MicroUSBCharger;
import com.develop.designpattern.adaptor.TypeCChargeAdaptor;

public class AdaptorClient {
    public static void main(String[] args) {
        MicroUSBCharger charger = new MicroUSBCharger();
        TypeCChargeAdaptor adaptor = new TypeCChargeAdaptor(charger);
        System.out.println(adaptor.cTypeCharger());
    }
}
