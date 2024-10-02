package com.Demo.device;


import com.Demo.AnaVodafone;
import com.Demo.driver.DriverSingleton;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;


public class Device {

    private final DriverSingleton driverSingleton = DriverSingleton.getDriverSingleton();
    public AnaVodafone anaVodafone = new AnaVodafone(driverSingleton.getDriver());

    public Device(int waitTime) {
        PageFactory.initElements(new AppiumFieldDecorator(driverSingleton.getDriver()), this);
    }


    public void launchApp() {
        System.out.println("entire lunch app");
        driverSingleton.getDriver().get("https://testing.todorvachev.com/register");
    }

    public void closeApp() {
        driverSingleton.getDriver().closeApp();
    }

    public void resetApp() {
        driverSingleton.getDriver().resetApp();
    }

}
