package com.Demo.driver;


import com.Demo.tests.BaseTest;
import com.Demo.utilities.ConfigHandler;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.util.Properties;

public class DriverSingleton extends BaseTest {
    public static final String PLATFORM_VERSION = "platformVersion";
    public static final String DEVICE_NAME = "deviceName";
    public static final String UDID = "udid";
    public static final String AUTOMATION_NAME = "automationName";
    private static final String PLATFORM_NAME = "platformName";
    private static Properties properties;
    private static DesiredCapabilities capabilities;
    private static DriverSingleton driverSingleton = null;
    private AppiumDriver<MobileElement> driver;

    private DriverSingleton() {
        if (androidPlatform)
            setAndroidDriver();
        else
            setIosDriver();
    }

    public static DriverSingleton getDriverSingleton() {
        if (driverSingleton == null)
            driverSingleton = new DriverSingleton();
        return driverSingleton;
    }

    private static void setIosDesiredCapabilities() throws IOException {

        capabilities = new DesiredCapabilities();
        capabilities.setCapability(PLATFORM_NAME, properties.getProperty(PLATFORM_NAME));
        capabilities.setCapability(PLATFORM_VERSION, properties.getProperty(PLATFORM_VERSION));
        capabilities.setCapability(DEVICE_NAME, properties.getProperty(DEVICE_NAME));
        capabilities.setCapability("newCommandTimeout", 1200);
        capabilities.setCapability(UDID, properties.getProperty(UDID));
        capabilities.setCapability(AUTOMATION_NAME, properties.getProperty(AUTOMATION_NAME, "UiAutomator2"));
        capabilities.setCapability("autoDismissAlerts", true);
        capabilities.setCapability("locale", "EG");
        capabilities.setCapability("unicodeKeyboard", true);
        capabilities.setCapability("resetKeyboard", true);
    }

    private static void setAppPackageAndActivity() {
        System.out.println("appp package" + properties.getProperty("appPackage"));
        System.out.println("appp activity " + properties.getProperty("appPackage"));
        capabilities.setCapability("appPackage", properties.getProperty("appPackage"));
        capabilities.setCapability("appActivity", properties.getProperty("appPackage"));
    }


    public AppiumDriver<MobileElement> getDriver() {
        return driver;
    }

    public void setAndroidDriver() {
        try {
            ConfigHandler.setAndroidProperties();
            properties = ConfigHandler.getAndroidProperties();
            setIosDesiredCapabilities();
            setAppPackageAndActivity();
            driver = new AndroidDriver(server.getCurrentServerUrl(), capabilities);
            driver.get("https://testing.todorvachev.com/register");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setIosDriver() {
        try {
            ConfigHandler.setIOSProperties();
            properties = ConfigHandler.getIOSProperties();
            setIosDesiredCapabilities();

            driver = new IOSDriver(server.getCurrentServerUrl(), capabilities);
            driver.get("https://testing.todorvachev.com/register");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
