package com.example.smarthome;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Tiny CSV loader for files like:
 * key,value
 * A-BULB-100,9
 */
public final class DeviceDataLoader {
    private DeviceDataLoader() {}

    public static Map<String, Integer> readCsv(String path) {
        Map<String, Integer> map = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isBlank() || line.startsWith("#") || line.startsWith("key")) continue;
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    String key = parts[0].trim();
                    int val = Integer.parseInt(parts[1].trim());
                    map.put(key, val);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read data file: " + path, e);
        }
        return map;
    }
}
