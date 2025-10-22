package com.practice.base;

import com.practice.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browser){
        Driver.initDriver(browser);
    }

    @AfterMethod
    public void tearDown(){
        Driver.quitDriver();
    }
}
