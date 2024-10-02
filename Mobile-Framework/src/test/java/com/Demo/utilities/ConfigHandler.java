package com.Demo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigHandler {

    public static final String ANDROID_CONFIG_PATH = "resources/config/config-android.properties";
    private static final String IOS_CONFIG_PATH = "resources/config/config-ios.properties";
    private static Properties androidProperties;
    private static Properties iOSProperties;


    public static void setIOSProperties() throws IOException {
        iOSProperties = new Properties();
        iOSProperties.load(new FileInputStream(IOS_CONFIG_PATH));
    }

    public static void setAndroidProperties() throws IOException {
        androidProperties = new Properties();
        androidProperties.load(new FileInputStream(ANDROID_CONFIG_PATH));
    }


    public static Properties getAndroidProperties() {
        return androidProperties;
    }

    public static Properties getIOSProperties() {
        return iOSProperties;
    }


}
