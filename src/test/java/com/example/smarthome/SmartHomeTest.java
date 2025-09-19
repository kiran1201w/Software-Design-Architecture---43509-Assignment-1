package com.example.smarthome;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SmartHomeTest {

    @Test
    void testUsageConfiguration() {
        SmartDeviceFactory brandA = new BrandASmartDeviceFactory();
        SmartDeviceFactory brandB = new BrandBSmartDeviceFactory();

        Bulb bulb = brandA.createBulb("100");
        bulb.configureUsage("data/bulbs.csv");
        assertEquals(9, bulb.getUsage(), "BrandA Bulb 100 should be 9W");

        Lock lock = brandB.createLock("Secure-Pro");
        lock.configureUsage("data/locks.csv");
        assertEquals(35, lock.getUsage(), "BrandB Lock Secure-Pro should be 35 mAh/day");
    }
}
