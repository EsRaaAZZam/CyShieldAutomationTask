package com.Demo.tests;

import com.Demo.driver.DriverSingleton;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {

    @BeforeMethod
    public void setUp() {
        if (androidPlatform)
            setupAndroid();
        else
            setupIos();
    }

    public void setupIos() {
        device.launchApp();
    }

    public void setupAndroid() {
        System.out.println("entire setupAndroid");
        device.launchApp();

    }

    @Test(priority = 1)
    public void checkAllElementsVisible() {
       device.anaVodafone.registrationPage.checkAllElementsVisible();
    }

//    @Test(priority = 2)
//    public void fillRegistrationFormWithInvalidData() {
//
//    }
//
//    @Test(priority = 3)
//    public void fillRegistrationFormWithValidData() {
//
//    }

    @AfterClass
    public void teardown() {

        DriverSingleton.getDriverSingleton().getDriver().quit();

    }

    @AfterMethod
    public void tearDown() {
        device.resetApp();
        device.closeApp();
        server.closeAppiumServer();
    }

}


