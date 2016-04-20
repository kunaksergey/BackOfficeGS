package ua.shield.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by sa on 12.04.16.
 */
public class Settings {
    public static float NDS = 0;
    private static final Settings INSTANCE = new Settings();
    private final Properties properties = new Properties();

    private Settings() {
        try {
            properties.load(new FileInputStream(this.getClass().getClassLoader().getResource("connect.properties").getFile()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Settings getInstance() {
        return INSTANCE;
    }

    public String value(String key) {
        return this.properties.getProperty(key);
    }
}
