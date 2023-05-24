package com.hostaway.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {

    private static final Properties APPLICATION_PROPERTY;
    private static final String APPLICATION_PROPERTY_PATH = "/application.properties";
    private static final String BASE_URL = "base_url";

    static {
        APPLICATION_PROPERTY = new Properties();
        try (InputStream stream = PropertyUtil.class.getResourceAsStream(APPLICATION_PROPERTY_PATH)) {
            if (stream != null) {
                APPLICATION_PROPERTY.load(stream);
            }
        } catch (IOException ex) {
            throw new IllegalStateException("Cannot read property " + APPLICATION_PROPERTY_PATH);
        }
    }

    public static String getBaseUrl() {
        return APPLICATION_PROPERTY.getProperty(BASE_URL);
    }
}
