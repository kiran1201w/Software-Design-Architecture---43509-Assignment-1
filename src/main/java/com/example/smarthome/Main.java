package com.example.smarthome;

public class Main {
    public static void main(String[] args) {
        // Paths to simulated "database" CSVs
        String bulbData = args.length > 0 ? args[0] : "data/bulbs.csv";
        String lockData = args.length > 1 ? args[1] : "data/locks.csv";

        // Abstract Factory usage
        SmartDeviceFactory brandA = new BrandASmartDeviceFactory();
        SmartDeviceFactory brandB = new BrandBSmartDeviceFactory();

        // Example 1: A Bulb from Brand A
        Bulb aBulb = brandA.createBulb("100");               // model "100"
        aBulb.configureUsage(bulbData);                      // Factory Method sets power after creation

        // Example 2: A Lock from Brand B
        Lock bLock = brandB.createLock("Secure-Pro");        // model "Secure-Pro"
        bLock.configureUsage(lockData);                      // Factory Method sets battery after creation

        System.out.println("== Demo ==");
        System.out.println(aBulb.info());
        System.out.println(bLock.info());
    }
}
