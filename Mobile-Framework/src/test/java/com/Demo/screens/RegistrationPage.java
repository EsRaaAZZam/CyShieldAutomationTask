package com.Demo.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;

import java.time.Duration;


public class RegistrationPage extends BaseScreen {
    private final By usernameInput = By.xpath("//input[@name='username']");
    private final By emailInput = By.xpath("//input[@name='email']");
    private final By passwordInput = By.xpath("//input[@name='passid']");
    private final By userIdInput = By.xpath("//input[@name='userid']");
    private final By addressInput = By.xpath("//input[@name='address']");
    private final By countrySelect = By.xpath("//select[@name='country']");
    private final By zipCodeInput = By.xpath("//input[@name='zip']");
    private final By sexInput = By.xpath("//input[@name='sex']");
    private final By submitButton = By.xpath("//input[@type='submit']");
    private final By successMessage = By.xpath("//div[@id='success-message']");
    private final By errorMessage = By.xpath("//div[@id='error-message']");

    public RegistrationPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public WebElement getCountrySelect() {
        RegistrationPage.waitForElementToBeVisible(countrySelect);
        return driver.findElement(countrySelect);
    }

    public WebElement getUsernameInput() throws InterruptedException {
        scrollUntilElementFound(usernameInput,5);
        return driver.findElement(usernameInput);
    }

    public WebElement getEmailInput() {
        RegistrationPage.waitForElementToBeVisible(emailInput);

        return  driver.findElement(emailInput);
    }

    public WebElement getPasswordInput() {
        RegistrationPage.waitForElementToBeVisible(passwordInput);

        return  driver.findElement(passwordInput);
    }

    public WebElement getUserIdInput() {
        RegistrationPage.waitForElementToBeVisible(userIdInput);
        return  driver.findElement(userIdInput);
    }

    public WebElement getAddressInput() {
        RegistrationPage.waitForElementToBeVisible(addressInput);
        return  driver.findElement(addressInput);
    }

    public WebElement getZipCodeInput() {
        RegistrationPage.waitForElementToBeVisible(zipCodeInput);
        return  driver.findElement(zipCodeInput);
    }

    public WebElement getSexInput() {
        RegistrationPage.waitForElementToBeVisible(sexInput);
        return  driver.findElement(sexInput);
    }

    public WebElement getSubmitButton() {
        RegistrationPage.waitForElementToBeVisible(submitButton);

        return  driver.findElement(submitButton);
    }


    public void enterFirstName(String name) {
        driver.findElement(usernameInput).sendKeys(name);
    }


    public void enterEmail(String emailStr) {
        driver.findElement(emailInput).sendKeys(emailStr);
    }

    public void enterPassword(String pwd) {
        driver.findElement(passwordInput).sendKeys(pwd);
    }

    public void clickRegister() {
        driver.findElement(submitButton).click();
    }

    public void fillRegistrationForm(String username, String email, String password, String userId, String address, String country, String zipCode, String sex) {
        driver.findElement(usernameInput).sendKeys(username);
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(userIdInput).sendKeys(userId);
        driver.findElement(addressInput).sendKeys(address);
        WebElement countryDropdown = driver.findElement(countrySelect);
        countryDropdown.sendKeys(country);
        driver.findElement(zipCodeInput).sendKeys(zipCode);
        driver.findElement(By.xpath("//input[@name='sex' and @value='" + sex + "']")).click();
    }

    public String getErrorMessage(AppiumDriver<MobileElement> driver) {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            System.out.println(" alert " + alert.getText());
            alert.accept();
            return alertText; // Return the alert message
        } catch (NoAlertPresentException e) {
            return null; // No alert is present
        }
    }
    public void scrollDown() {
        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(500, 1500))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(500, 500))
                .release()
                .perform();
    }

    public void scrollUntilElementFound(By locator, int maxAttempts) {
        boolean found = false;
        int attempts = 0;

        while (!found && attempts < maxAttempts) {
            try {
                driver.findElement(locator);
                found = true;
            } catch (NoSuchElementException e) {
                scrollDown();
                attempts++;
            } catch (StaleElementReferenceException e) {
            }
        }

        if (!found) {
            System.out.println("Element not found after " + maxAttempts + " attempts.");
        }
    }
}

