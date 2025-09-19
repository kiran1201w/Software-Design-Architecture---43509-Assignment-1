package com.example.smarthome;

public interface SmartDevice {
    String getBrand();
    String getModel();
    /**
     * For Bulb: power usage in watts; for Lock: battery consumption in mAh/day (example metric).
     */
    int getUsage();
    void configureUsage(String dataPath);
    String info();
}
