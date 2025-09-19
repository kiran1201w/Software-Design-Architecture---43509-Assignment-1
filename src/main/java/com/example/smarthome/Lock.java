package com.example.smarthome;

import java.util.Map;

public class Lock extends AbstractSmartDevice {
    public Lock(String brand, String model) {
        super(brand, model);
    }

    @Override
    protected UsageRecord createUsageRecord(String dataPath) {
        Map<String, Integer> map = DeviceDataLoader.readCsv(dataPath);
        // key format: <BRAND>-LOCK-<MODEL>
        String key = "%s-LOCK-%s".formatted(brand, model);
        Integer v = map.get(key);
        return (v != null) ? new UsageRecord(key, v) : null;
    }

    @Override
    public String info() {
        return "Lock %s %s - battery=%dmAh/day".formatted(brand, model, usage);
    }
}
