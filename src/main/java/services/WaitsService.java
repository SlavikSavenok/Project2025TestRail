package services;

import configuration.ReadProperties;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitsService {
    private WebDriverWait wait;
    private WebDriver driver;

    public WaitsService(WebDriver driver, Duration duration) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, duration);
    }

    public WaitsService(WebDriver driver) {
        this(driver, Duration.ofSeconds(ReadProperties.timeout()));
    }

    public WebElement elementToBeClickable(By by) {
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public WebElement waitVisibilityOf(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement presenceOfElementLocated(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement waitVisibilityOf(WebElement webElement) {
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }
}