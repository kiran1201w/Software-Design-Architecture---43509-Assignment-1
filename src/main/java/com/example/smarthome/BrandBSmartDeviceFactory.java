package com.example.smarthome;

public class BrandBSmartDeviceFactory implements SmartDeviceFactory {
    private static final String BRAND = "BrandB";

    @Override
    public Bulb createBulb(String model) {
        return new Bulb(BRAND, model);
    }

    @Override
    public Lock createLock(String model) {
        return new Lock(BRAND, model);
    }
}
