package com.Demo.device;


import com.Demo.driver.DriverSingleton;
import com.Demo.registerApp;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Device {

    private final DriverSingleton driverSingleton = DriverSingleton.getDriverSingleton();


    public registerApp registerApp = new registerApp(driverSingleton.getDriver());



    public Device(int waitTime) {

        PageFactory.initElements(new AppiumFieldDecorator(driverSingleton.getDriver(), Duration.ofSeconds(waitTime)), this);
    }


    public void launchApp() {
        String url = "https://testing.todorvachev.com/register"; // Replace with your desired URL
        driverSingleton.getDriver().get(url);
    }


    public void closeApp() {
        driverSingleton.getDriver().closeApp();
    }


}
