package com.practice.logging;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.practice.constants.FrameWorkConstants;

public class ExtentReport {

    private ExtentReport(){}

    private static ExtentReports extentReports;
    private static ExtentTest extentTest;

    public static void initReports(){
        extentReports = new ExtentReports();
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(FrameWorkConstants.getReportPath());

        // Configure for Jenkins compatibility
        extentSparkReporter.config().setReportName("Selenium Automation Test Report");
        extentSparkReporter.config().setDocumentTitle("Test Execution Report");
        extentSparkReporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
        extentSparkReporter.config().setTheme(com.aventstack.extentreports.reporter.configuration.Theme.STANDARD);
        extentSparkReporter.config().setEncoding("UTF-8");

        // Add system information
        extentReports.setSystemInfo("OS", System.getProperty("os.name"));
        extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
        extentReports.setSystemInfo("User", System.getProperty("user.name"));
        extentReports.setSystemInfo("Environment", "Test");

        extentReports.attachReporter(extentSparkReporter);
    }

    public static void flushReports(){
        extentReports.flush();
    }

    public static void createTest(String testCaseName){
        extentTest = extentReports.createTest(testCaseName);
        ExtentManager.setExtentTest(extentTest);
    }
}
