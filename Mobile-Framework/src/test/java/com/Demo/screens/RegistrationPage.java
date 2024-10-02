package com.Demo.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.*;

public class RegistrationPage extends BaseScreen {


    private final By usernameInput = By.name("username");
    private final By emailInput = By.name("email");
    private final By passwordInput = By.name("passid");
    private final By userIdInput = By.name("userid");
    private final By addressInput = By.name("address");
    private final By countrySelect = By.name("country");
    private final By zipCodeInput = By.name("zip");
    private final By sexInput = By.name("sex");
    private final By submitButton = By.xpath("//input[@type='submit']");
    private final By successMessage = By.id("success-message");
    private final By errorMessage = By.id("error-message"); //

    public RegistrationPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public WebElement getCountrySelect() {
        return driver.findElement(countrySelect);
    }

    public WebElement getUsernameInput() {
        return driver.findElement(usernameInput);
    }

    public WebElement getEmailInput() {
        return driver.findElement(emailInput);
    }

    public WebElement getPasswordInput() {
        return driver.findElement(passwordInput);
    }

    public WebElement getUserIdInput() {
        return driver.findElement(userIdInput);
    }

    public WebElement getAddressInput() {
        return driver.findElement(addressInput);
    }

    public WebElement getZipCodeInput() {
        return driver.findElement(zipCodeInput);
    }

    public WebElement getSexInput() {
        return driver.findElement(sexInput);
    }

    public WebElement getSubmitButton() {
        return driver.findElement(submitButton);
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

    public String getErrorMessage(WebDriver driver) {
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

}