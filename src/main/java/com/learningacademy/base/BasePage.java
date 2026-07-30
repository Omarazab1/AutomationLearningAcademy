package com.learningacademy.base;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected final Logger logger =
            LoggerFactory.getLogger(getClass());
    protected WebDriver driver;
    protected WebDriverWait wait;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    protected void scrollTo(By locator) {
        WebElement element = find(locator);

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                element
        );
    }
    public void goBack() {
        driver.navigate().back();
    }

    /**
     * Finds and returns a web element.
     */
    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }
    protected List<WebElement> finds(By locator) {
        return driver.findElements(locator);
    }

    /**
     * Click on an element.
     */
    protected void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    /**
     * Clear the field then enter text.
     */
    protected void enterText(By locator, String text) {

        WebElement element =
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        element.clear();
        element.sendKeys(text);
    }

    /**
     * Returns true if the element is displayed.
     */
    protected boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Returns the text of an element.
     */
    protected String getText(By locator) {
        return find(locator).getText();
    }

    /**
     * Returns the current page title.
     */
    protected String getPageTitle() {
        return driver.getTitle();
    }

    /**
     * Returns the current page URL.
     */
    protected String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
