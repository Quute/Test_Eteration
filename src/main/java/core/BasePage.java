package core;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public abstract class BasePage {
    protected final WebDriver driver;
    protected final WebDriverWait wait;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected void go(String url){ driver.get(url); }

    protected WebElement waitClickable(By by){
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    protected void click(By by){ waitClickable(by).click(); }

    protected void waitUrlContains(String part){
        wait.until(ExpectedConditions.urlContains(part));
    }
}
