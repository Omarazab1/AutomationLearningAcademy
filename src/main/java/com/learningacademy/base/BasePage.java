package com.learningacademy.base;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Finds and returns a web element.
     */
    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    /**
     * Click on an element.
     */
    protected void click(By locator) {
        find(locator).click();
    }
    /**
     * Clear the field then enter text.
     */
    protected void enterText(By locator, String text) {
        WebElement element = find(locator);
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
