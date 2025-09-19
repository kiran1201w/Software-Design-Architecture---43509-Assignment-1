package com.example.smarthome;

import java.util.Map;

public class Bulb extends AbstractSmartDevice {
    public Bulb(String brand, String model) {
        super(brand, model);
    }

    @Override
    protected UsageRecord createUsageRecord(String dataPath) {
        Map<String, Integer> map = DeviceDataLoader.readCsv(dataPath);
        // key format: <BRAND>-BULB-<MODEL>
        String key = "%s-BULB-%s".formatted(brand, model);
        Integer v = map.get(key);
        return (v != null) ? new UsageRecord(key, v) : null;
    }

    @Override
    public String info() {
        return "Bulb %s %s - power=%dW".formatted(brand, model, usage);
    }
}
