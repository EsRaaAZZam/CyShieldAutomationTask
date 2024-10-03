package com.Demo.screens;

import com.Demo.driver.DriverSingleton;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseScreen {
    private static WebDriverWait wait = new WebDriverWait(DriverSingleton.getDriverSingleton().getDriver(), 35);
    protected AppiumDriver<MobileElement> driver;

    public BaseScreen(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(30)), this);
    }



    public static void waitForElementToBeVisible(By elementBy) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
    }



}
