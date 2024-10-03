package com.Demo;

import com.Demo.screens.RegistrationPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class registerApp {


    public RegistrationPage registrationPage;

    public registerApp(AppiumDriver<MobileElement> driver) {
        this.registrationPage = new RegistrationPage(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(30)), this);
    }


}
