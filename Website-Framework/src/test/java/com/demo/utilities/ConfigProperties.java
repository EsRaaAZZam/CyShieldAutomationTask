package com.demo.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {

    private final String configFilePath;
    private Properties properties;

    public ConfigProperties(String configFilePath) throws IOException {
        this.configFilePath = configFilePath;
        setConfigProperties();
    }

    private void setConfigProperties() throws IOException {
        properties = new Properties();
        properties.load(new FileInputStream(configFilePath));
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public String getBaseUrl() {
        return properties.getProperty("base.url");
    }

    public String getFirstName() {
        return properties.getProperty("first.name");
    }

    public String getLastName() {
        return properties.getProperty("last.name");
    }

    public String getValidEmail() {
        return properties.getProperty("valid.email");
    }

    public String getInvalidEmail() {
        return properties.getProperty("invalid.email");
    }
    public String getTestPassword() {
        return properties.getProperty("test.password");
    }

    public String getPassword() {
        return properties.getProperty("password");
    }
}
