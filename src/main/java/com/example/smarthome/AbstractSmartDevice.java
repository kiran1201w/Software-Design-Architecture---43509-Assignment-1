package com.example.smarthome;

public abstract class AbstractSmartDevice implements SmartDevice {
    protected final String brand;
    protected final String model;
    protected int usage; // watts for bulbs; mAh/day for locks (example)

    protected AbstractSmartDevice(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    @Override
    public String getBrand() { return brand; }

    @Override
    public String getModel() { return model; }

    @Override
    public int getUsage() { return usage; }

    @Override
    public void configureUsage(String dataPath) {
        UsageRecord record = createUsageRecord(dataPath);
        if (record == null) {
            throw new IllegalStateException("Usage record not found for " + brand + " " + model + " in " + dataPath);
        }
        this.usage = record.value();
    }

    /**
     * Factory Method: defer creation of the UsageRecord to subclasses, which
     * decide how to read and interpret the data file for their product type.
     */
    protected abstract UsageRecord createUsageRecord(String dataPath);

    @Override
    public String info() {
        return "%s %s (usage=%d)".formatted(brand, model, usage);
    }
}
