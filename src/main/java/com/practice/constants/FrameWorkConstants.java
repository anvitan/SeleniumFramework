package com.practice.constants;

public class FrameWorkConstants {

    private FrameWorkConstants(){}

    private static final String REPORT_PATH = System.getProperty("user.dir")+"/target/artifacts/index.html";

    public static String getReportPath(){
        return REPORT_PATH;
    }
}
