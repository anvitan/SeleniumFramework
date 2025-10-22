package com.practice.logging;

import com.epam.reportportal.service.ReportPortal;

import java.io.File;
import java.util.Date;

public class ReportPortalLogger implements ILogger{
    @Override
    public void info(String message) {
        ReportPortal.emitLog(message,"INFO",new Date());
    }

    @Override
    public void error(String message) {
        ReportPortal.emitLog(message,"ERROR",new Date());
    }

    @Override
    public void warn(String message) {
        ReportPortal.emitLog(message,"WARN",new Date());
    }

    @Override
    public void debug(String message) {
        ReportPortal.emitLog(message,"DEBUG",new Date());
    }

    @Override
    public void step(String stepDescription) {

    }

    @Override
    public void testStart(String testName) {

    }

    @Override
    public void testEnd(String testName) {

    }

    @Override
    public void browserAction(String action, String element) {
        ReportPortal.emitLog(action +" performed on "+element,"INFO",new Date());
    }

    @Override
    public void assertion(String description, boolean result) {

    }

    @Override
    public void attachScreenshot(String testName, File file) {
        ReportPortal.emitLog(testName, "INFO",new Date(),file);
    }

    @Override
    public void attachFile(String message, String content, String fileName) {
    }

    @Override
    public void apiLog(String endpoint, String method, String requestBody, String responseBody) {

    }

    @Override
    public void errorWithScreenshot(String message) {

    }

    @Override
    public void pass(String message) {
        ReportPortal.emitLog(message,"INFO",new Date());
    }

    @Override
    public void fail(String message) {
        ReportPortal.emitLog(message,"ERROR",new Date());
    }

    @Override
    public void skip(String message) {

    }
}
