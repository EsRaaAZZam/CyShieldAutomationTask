package com.Demo.tests;

import com.Demo.utilities.extent_report.ExtentReport;
import com.Demo.utilities.extent_report.ScreenShot;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class RegistrationTest extends BaseTest {


    @Test
    public void checkAllElementsVisible() throws InterruptedException {

        Assert.assertTrue(device.registerApp.registrationPage.getUsernameInput().isDisplayed());
        Assert.assertTrue(device.registerApp.registrationPage.getEmailInput().isDisplayed());
        Assert.assertTrue(device.registerApp.registrationPage.getPasswordInput().isDisplayed());
        Assert.assertTrue(device.registerApp.registrationPage.getUserIdInput().isDisplayed());
        Assert.assertTrue(device.registerApp.registrationPage.getAddressInput().isDisplayed());
        Assert.assertTrue(device.registerApp.registrationPage.getCountrySelect().isDisplayed());
        Assert.assertTrue(device.registerApp.registrationPage.getZipCodeInput().isDisplayed());
        Assert.assertTrue(device.registerApp.registrationPage.getSexInput().isDisplayed());
        Assert.assertTrue(device.registerApp.registrationPage.getSubmitButton().isDisplayed());
    }

    @BeforeClass
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
        device.launchApp();
    }






}
