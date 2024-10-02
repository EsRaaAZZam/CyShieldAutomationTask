package com.Demo;


import com.Demo.driver.DriverSingleton;
import com.Demo.screens.RegistrationPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AnaVodafone {

    public RegistrationPage registrationPage;

    public AnaVodafone(AppiumDriver<MobileElement> driver) {
        registrationPage = new RegistrationPage(DriverSingleton.getDriverSingleton().getDriver());
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }



    public boolean areElementsHorizontallySorted(MobileElement first, MobileElement second, String language) {
        return (language.equals("en")) == areElementsHorizontallySorted(first, second);
    }

    public boolean areElementsHorizontallySorted(MobileElement first, MobileElement second) {
        return (first.getLocation().x < second.getLocation().x);
    }

    public boolean areElementsVerticallySorted(MobileElement first, MobileElement second) {
        return (first.getLocation().y < second.getLocation().y);
    }

    public void waitForLoadingToFinish() {
        WebDriverWait wait = new WebDriverWait(DriverSingleton.getDriverSingleton().getDriver(), 35);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.emeint.android.myservices:id/progress_overlay")));
    }

    public void waitUntilInvisibilityOfElement(MobileElement element) {
        WebDriverWait wait = new WebDriverWait(DriverSingleton.getDriverSingleton().getDriver(), 15);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(element.getId())));
    }

    public String getElementColor(MobileElement element) {
        return element.getAttribute("color");
    }

    public Boolean isChecked(MobileElement element) {
        return Boolean.parseBoolean(element.getAttribute("checked"));
    }


}
