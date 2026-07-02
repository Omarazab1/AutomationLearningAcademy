package com.learningacademy.base;

import com.learningacademy.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
        protected WebDriver driver;
        public BasePage() {
            this.driver = DriverFactory.getDriver();
            PageFactory.initElements(driver, this);
        }
    protected void click(WebElement element) {
        element.click();
    }

    protected void type(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    protected String getText(WebElement element) {
        return element.getText();
    }

    protected boolean isDisplayed(WebElement element) {
        return element.isDisplayed();
    }
    }

