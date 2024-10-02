package com.Demo.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


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
    private final By errorMessage = By.id("error-message");

    public RegistrationPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public void checkAllElementsVisible() {
//        try {
//            assertElementIsVisible(emailInput, "Email input is not visible");
//            assertElementIsVisible(passwordInput, "Password input is not visible");
//            assertElementIsVisible(userIdInput, "User ID input is not visible");
//            assertElementIsVisible(addressInput, "Address input is not visible");
//            assertElementIsVisible(countrySelect, "Country select is not visible");
//            assertElementIsVisible(zipCodeInput, "Zip code input is not visible");
//            assertElementIsVisible(sexInput, "Sex input is not visible");
//            assertElementIsVisible(submitButton, "Submit button is not visible");
//        } catch (Exception e) {
//            System.out.println("An error occurred while checking visibility: " + e.getMessage());
//        }

        System.out.println("reached here" +
                "");
    }

    private void assertElementIsVisible(By locator, String errorMessage) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        if (!element.isDisplayed()) {
            throw new AssertionError(errorMessage);
        }
    }

    public void fillRegistrationForm(String username, String email, String password, String userId, String address, String country, String zip, String sex) {

    }

    public void submitForm() {
        driver.findElement(submitButton).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}
