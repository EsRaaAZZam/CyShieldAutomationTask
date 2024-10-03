package com.Demo.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigHandler {

    public static final String ANDROID_CONFIG_PATH = "resources/config/config-android.properties";
    public static final String VF_CASH_CONFIG_PATH = "resources/config/config-vfCash.properties";
    public static final String CREDIT_CARDS_CONFIG_PATH = "resources/config/config-credit-cards.properties";
    public static final String SCRATCH_CARDS_CONFIG_PATH = "resources/config/config-scratch-cards.properties";
    public static final String RATE_PLANES_CONFIG_PATH = "resources/config/config-rateplan.properties";
    private static final String IOS_CONFIG_PATH = "resources/config/config-ios.properties";
    private static Properties androidProperties;
    private static Properties vfCashProperties;
    private static Properties creditCardsProperties;
    private static Properties scratchCardsProperties;
    private static Properties ratePlanesProperties;
    private static Properties iOSProperties;

    public static void setConfigProperties() throws IOException {
        setRatePlanesProperties();
        setScratchCardsProperties();
        setCreditCardsProperties();
        setVfCashProperties();
    }

    public static void setIOSProperties() throws IOException {
        iOSProperties = new Properties();
        iOSProperties.load(new FileInputStream(IOS_CONFIG_PATH));
    }

    public static void setAndroidProperties() throws IOException {
        androidProperties = new Properties();
        androidProperties.load(new FileInputStream(ANDROID_CONFIG_PATH));
    }

    public static void setVfCashProperties() throws IOException {
        vfCashProperties = new Properties();
        vfCashProperties.load(new FileInputStream(VF_CASH_CONFIG_PATH));
    }

    public static void setCreditCardsProperties() throws IOException {
        creditCardsProperties = new Properties();
        creditCardsProperties.load(new FileInputStream(CREDIT_CARDS_CONFIG_PATH));
    }

    public static void setScratchCardsProperties() throws IOException {
        scratchCardsProperties = new Properties();
        scratchCardsProperties.load(new FileInputStream(SCRATCH_CARDS_CONFIG_PATH));
    }

    public static void setRatePlanesProperties() throws IOException {
        ratePlanesProperties = new Properties();
        ratePlanesProperties.load(new FileInputStream(RATE_PLANES_CONFIG_PATH));
    }

    public static Properties getAndroidProperties() {
        return androidProperties;
    }

    public static Properties getVfCashProperties() {
        return vfCashProperties;
    }

    public static Properties getCreditCardsProperties() {
        return creditCardsProperties;
    }


    public static Properties getScratchCardsProperties() {
        return scratchCardsProperties;
    }

    public static Properties getRatePlanesProperties() {
        return ratePlanesProperties;
    }

    public static Properties getIOSProperties() {
        return iOSProperties;
    }

    public static void updateScratchCardsConfig() throws IOException {
        scratchCardsProperties.store(new FileOutputStream(SCRATCH_CARDS_CONFIG_PATH), null);
    }

    public static void updateCreditCardsConfig() throws IOException {
        creditCardsProperties.store(new FileOutputStream(CREDIT_CARDS_CONFIG_PATH), null);
    }

    public static void updateVFCashConfig() throws IOException {
        vfCashProperties.store(new FileOutputStream(VF_CASH_CONFIG_PATH), null);
    }
}
