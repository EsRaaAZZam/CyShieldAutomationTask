package com.demo.utilities.listeners;

import com.aventstack.extentreports.Status;
import org.testng.IAlterSuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.List;


public class TestNGListener implements IAlterSuiteListener, ITestListener {

    private static XmlSuite suite;
    final private String REPORT_NAME_PARAM = "ReportName";



    @Override
    public void alter(List<XmlSuite> suites) {

        suite = suites.get(0);
        List<XmlTest> testsList = suite.getTests();
        suite.setTests(new ArrayList<>());
        List<XmlTest> updatedTestsList = new ArrayList<>();

        for (XmlTest test : testsList) {
            XmlTest newTest = getXmlTest(test);
            updatedTestsList.add(newTest);
        }
        suite.setTests(updatedTestsList);
    }

    private XmlTest getXmlTest(XmlTest test) {
        String testName = test.getName();

        XmlTest newTest = new XmlTest(suite);

        newTest.setName(testName);
        newTest.setClasses(test.getClasses());

        newTest.addParameter(REPORT_NAME_PARAM, testName);
        return newTest;
    }
    @Override
    public void onStart(ITestContext context) {
        System.out.println("AlternativeListener onStart called.");
    }

}