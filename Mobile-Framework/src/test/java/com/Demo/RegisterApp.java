package com.Demo;


import com.Demo.driver.DriverSingleton;
import com.Demo.screens.RegistrationPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class RegisterApp {

    public RegistrationPage registrationPage;

    public RegisterApp(AppiumDriver<MobileElement> driver) {
        registrationPage = new RegistrationPage(DriverSingleton.getDriverSingleton().getDriver());
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


}
