package com.demo.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.demo.browser.Browser;
import com.demo.driver.WebDriverHandler;
import com.demo.utilities.ConfigProperties;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegistrationTest extends BaseTest {
    private ExtentReports extent;
    private ExtentTest test;
    @BeforeMethod
    @Parameters("browser")
    public void setUpWebsite() throws IOException {

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("reports/extent.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        test = extent.createTest("Registration Test");
        System.out.println("Browser name entire setup: " + getBrowserName());
        if (getBrowserName() == null) {
            String browserType = "resources/config/configBrowser.properties";
            ConfigProperties configBrowser = new ConfigProperties(browserType);
            String driverType = configBrowser.getProperty("driverType");
            webDriverHandler = new WebDriverHandler(driverType);
        } else {
            webDriverHandler = new WebDriverHandler(getBrowserName());
        }

        browser = new Browser();
        WebDriverHandler.getDriver().navigate().to("https://testing.todorvachev.com/register");
        users = new ConfigProperties("resources/config/users.properties");
    }


    @Test
    public void testAllElementsVisible() {
        test.info("Checking all elements visibility.");
        Assert.assertTrue( browser.applicationPage.registerPage.getUsernameInput().isDisplayed());
        Assert.assertTrue( browser.applicationPage.registerPage.getEmailInput().isDisplayed());
        Assert.assertTrue(browser.applicationPage.registerPage.getPasswordInput().isDisplayed());
        Assert.assertTrue( browser.applicationPage.registerPage.getUserIdInput().isDisplayed());
        Assert.assertTrue(browser.applicationPage.registerPage.getAddressInput().isDisplayed());
        Assert.assertTrue( browser.applicationPage.registerPage.getCountrySelect().isDisplayed());
        Assert.assertTrue( browser.applicationPage.registerPage.getZipCodeInput().isDisplayed());
        Assert.assertTrue( browser.applicationPage.registerPage.getSexInput().isDisplayed());
        Assert.assertTrue( browser.applicationPage.registerPage.getSubmitButton().isDisplayed());
        test.pass("All elements are visible.");

    }

    @Test
    public void testRegistrationWithInvalidAddress() {
        test.info("Testing registration with invalid address.");
        browser.applicationPage.registerPage.fillRegistrationForm(
                users.getProperty("invalid.username"),
                users.getProperty("invalid.email"),
                users.getProperty("invalid.password"),
                users.getProperty("invalid.user_id"),
                users.getProperty("invalid.address"),
                users.getProperty("invalid.country"),
                users.getProperty("invalid.zip_code"),
                users.getProperty("invalid.sex")
        );
        browser.applicationPage.registerPage.clickRegister();
        String alertMessage = browser.applicationPage.registerPage.getErrorMessage(WebDriverHandler.getDriver());
        System.out.println("alert enture"+ alertMessage);
        Assert.assertTrue(alertMessage.contains(users.getProperty("error.message")));
        test.pass("Error message displayed as expected.");

    }

    @Test
    public void testRegistrationWithValidData() {
        test.info("Testing registration with valid data.");
        browser.applicationPage.registerPage.fillRegistrationForm(
                users.getProperty("valid.username"),
                users.getProperty("valid.email"),
                users.getProperty("test.password"),
                users.getProperty("valid.user_id"),
                users.getProperty("valid.address"),
                users.getProperty("valid.country"),
                users.getProperty("valid.zip_code"),
                users.getProperty("valid.sex")
        );
        browser.applicationPage.registerPage.clickRegister();
        String alertMessage = browser.applicationPage.registerPage.getErrorMessage(WebDriverHandler.getDriver());
        System.out.println("alert enture"+ alertMessage);
        test.pass("Registration successful.");
    }

    @AfterMethod
    public void tearDown() {
        WebDriverHandler.closeDriver();
        extent.flush();
    }
}
