package com.develop.designpattern.adaptor;

public class TypeCChargeAdaptor implements TypeCCharger{
    private MicroUSBCharger microUSBCharger;
    public TypeCChargeAdaptor(MicroUSBCharger microUSBCharger) {
        this.microUSBCharger = microUSBCharger;
    }

    @Override
    public String cTypeCharger() {

        return microUSBCharger.microUSBCharger() + " converting to TypeC Charger";
    }
}
