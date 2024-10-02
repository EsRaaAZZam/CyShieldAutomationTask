package com.demo;

import com.demo.driver.WebDriverHandler;
import com.demo.pages.*;
import org.openqa.selenium.WebDriver;

public class ApplicationPage extends BasePage {

    private final WebDriver webDriver = WebDriverHandler.getDriver();
    public RegisterPage registerPage;
    private String currentLanguage;


    public ApplicationPage() {

        registerPage = new RegisterPage();
    }

}