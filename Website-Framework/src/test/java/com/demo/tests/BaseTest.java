package com.demo.tests;

import com.demo.browser.Browser;
import com.demo.driver.WebDriverHandler;
import com.demo.utilities.ConfigProperties;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Map;

public class BaseTest implements ITestListener {

    protected static ConfigProperties users;
    protected WebDriverHandler webDriverHandler;
    protected static Browser browser;

    private static final ThreadLocal<String> browserName = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {
        System.out.println("onStart method called.");

        Map<String, String> parameters = context.getCurrentXmlTest().getAllParameters();
        String browserParam = parameters.get("browser");
        browserName.set(browserParam);
        System.out.println("Browser set: " + browserName.get());
    }


    public static String getBrowserName() {
        return browserName.get();
    }
}
