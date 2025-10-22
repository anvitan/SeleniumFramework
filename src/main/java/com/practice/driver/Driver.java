package com.practice.driver;

import org.openqa.selenium.WebDriver;
import com.practice.config.ConfigReader;
import com.practice.utils.LoggerUtils;

import java.time.Duration;

public class Driver {
    private Driver() {
    }

    public static void initDriver(String browser) {
        WebDriver driver = DriverFactory.getDriver(browser);
        DriverManager.setDriver(driver);
        long timeOut = ConfigReader.getConfig().timeout();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOut));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeOut));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(timeOut));
        driver.manage().window().maximize();
        driver.get(ConfigReader.getConfig().url());
        LoggerUtils.info(browser+" driver is created successfully");
    }

    public static void quitDriver() {
        WebDriver driver = DriverManager.getDriver();
        if (driver != null) {
            driver.quit();
            DriverManager.setDriver(null);
        }
    }
}
