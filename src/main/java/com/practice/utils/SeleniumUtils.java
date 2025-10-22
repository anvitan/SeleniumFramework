package com.practice.utils;

import com.practice.config.ConfigReader;
import com.practice.enumss.WaitType;
import com.practice.exceptions.InvalidWaitTypeException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.practice.driver.DriverManager;
import java.time.Duration;


public final class SeleniumUtils {

    private SeleniumUtils(){}

    public static void sendKeys(By by, String value) {
        WaitUtils.waitFor(200L);
        WebElement element = waitUntilElementToBePresent(by);
        element.sendKeys(value);

    }

    public static void click(By by, WaitType waitType) {
        if (waitType == WaitType.PRESENCE)
            click(waitUntilElementToBePresent(by));
        else if (waitType == WaitType.CLICKABLE)
            click(waitUntilElementToBeClickable(by));
        else if (waitType == WaitType.VISIBLE)
            click(waitUntilElementToBeVisible(by));
        else
            try {
                throw new InvalidWaitTypeException("Invalid Wait Type");
            } catch (InvalidWaitTypeException e) {
                throw new RuntimeException(e);
            }
    }

    public static void click(WebElement element) {
        WaitUtils.waitFor(2,"Waiting for click to happen");
        element.click();
    }

    public static WebElement waitUntilElementToBePresent(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(ConfigReader.getConfig().timeout()));
        return wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static WebElement waitUntilElementToBeClickable(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(ConfigReader.getConfig().timeout()));
        return wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(by));
    }

    public static WebElement waitUntilElementToBeVisible(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(ConfigReader.getConfig().timeout()));
        return wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void scrollToElementUsingActions(By by) {
        WebDriver driver = DriverManager.getDriver();
        scrollToElementUsingJs(by);
        new Actions(driver).scrollToElement(driver.findElement(by));
    }

    public static void scrollToElementUsingJs(By by) {
        WebDriver driver = DriverManager.getDriver();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", driver.findElement(by));
    }

    public static String getText(By by){
        WebElement element = waitUntilElementToBePresent(by);
        return element.getText();
    }

    public static void clickUsingActions(WebElement element){
        WebDriver driver = DriverManager.getDriver();
        new Actions(driver).click(element).build().perform();
    }
}
