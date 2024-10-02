package com.demo.pages;

import org.openqa.selenium.*;

public class RegisterPage extends BasePage {


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

    public WebElement getCountrySelect() {
        return findElement(countrySelect);
    }

    public WebElement getUsernameInput() {
        return findElement(usernameInput);
    }

    public WebElement getEmailInput() {
        return findElement(emailInput);
    }

    public WebElement getPasswordInput() {
        return findElement(passwordInput);
    }

    public WebElement getUserIdInput() {
        return findElement(userIdInput);
    }

    public WebElement getAddressInput() {
        return findElement(addressInput);
    }

    public WebElement getZipCodeInput() {
        return findElement(zipCodeInput);
    }

    public WebElement getSexInput() {
        return findElement(sexInput);
    }

    public WebElement getSubmitButton() {
        return findElement(submitButton);
    }



    public void enterFirstName(String name) {
        findElement(usernameInput).sendKeys(name);
    }


    public void enterEmail(String emailStr) {
        findElement(emailInput).sendKeys(emailStr);
    }

    public void enterPassword(String pwd) {
        findElement(passwordInput).sendKeys(pwd);
    }

    public void clickRegister() {
        findElement(submitButton).click();
    }

    public void fillRegistrationForm(String username, String email, String password, String userId, String address, String country, String zipCode, String sex) {
      findElement(usernameInput).sendKeys(username);
      findElement(emailInput).sendKeys(email);
      findElement(passwordInput).sendKeys(password);
      findElement(userIdInput).sendKeys(userId);
      findElement(addressInput).sendKeys(address);
      WebElement countryDropdown = findElement(countrySelect);
      countryDropdown.sendKeys(country);
      findElement(zipCodeInput).sendKeys(zipCode);
      findElement(By.xpath("//input[@name='sex' and @value='" + sex + "']")).click();
    }




    public String getErrorMessage(WebDriver driver) {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            System.out.println(" alert " + alert.getText() );
            alert.accept();
            return alertText; // Return the alert message
        } catch (NoAlertPresentException e) {
            return null; // No alert is present
        }
    }

}