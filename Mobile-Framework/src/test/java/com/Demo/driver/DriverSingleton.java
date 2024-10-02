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

import static org.openqa.selenium.remote.CapabilityType.BROWSER_NAME;

public class DriverSingleton extends BaseTest {
    private static final String PLATFORM_VERSION = "platformVersion";
    private static final String DEVICE_NAME = "deviceName";
    private static final String UDID = "udid";
    private static final String AUTOMATION_NAME = "automationName";
    private static final String PLATFORM_NAME = "platformName";
    private static Properties properties;
    private static DesiredCapabilities capabilities;
    private static DriverSingleton driverSingleton = null;
    private AppiumDriver<MobileElement> driver;

    private DriverSingleton() {
        if (androidPlatform) {
            setAndroidDriver();
        } else {
            setIosDriver();
        }
    }


    public static DriverSingleton getDriverSingleton() {
        System.out.println("sdwxsz");
        if (driverSingleton == null) {
            driverSingleton = new DriverSingleton();

            System.out.println("sdesdexszdexs");
        }
        return driverSingleton;
    }

    private static void setDesiredCapabilities() throws IOException {
        System.out.println("settttt");
        capabilities = new DesiredCapabilities();
        capabilities.setCapability(PLATFORM_NAME, properties.getProperty(PLATFORM_NAME));
        capabilities.setCapability(PLATFORM_VERSION, properties.getProperty(PLATFORM_VERSION));
        capabilities.setCapability(DEVICE_NAME, properties.getProperty(DEVICE_NAME));
        capabilities.setCapability(BROWSER_NAME, "Chrome");
        capabilities.setCapability("newCommandTimeout", 1200);
        capabilities.setCapability(AUTOMATION_NAME, properties.getProperty(AUTOMATION_NAME, "UiAutomator2"));
        capabilities.setCapability("autoDismissAlerts", true);
        capabilities.setCapability("locale", "EG");
        capabilities.setCapability("unicodeKeyboard", true);
        capabilities.setCapability("resetKeyboard", true);

    }

    public AppiumDriver<MobileElement> getDriver() {
        return driver;
    }

    private void setAndroidDriver() {
        System.out.println("setAndroidDriver ");
        try {
            ConfigHandler.setAndroidProperties();
            properties = ConfigHandler.getAndroidProperties();
            setDesiredCapabilities();
            driver = new AndroidDriver<>(server.getCurrentServerUrl(), capabilities);
            driver.get("https://testing.todorvachev.com/register");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setIosDriver() {
        try {
            ConfigHandler.setIOSProperties();
            properties = ConfigHandler.getIOSProperties();
            setDesiredCapabilities();
            driver = new IOSDriver<>(server.getCurrentServerUrl(), capabilities);
            driver.get("https://testing.todorvachev.com/register");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
