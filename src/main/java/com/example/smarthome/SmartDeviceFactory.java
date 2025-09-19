package com.example.smarthome;

public interface SmartDeviceFactory {
    Bulb createBulb(String model);
    Lock createLock(String model);
}
