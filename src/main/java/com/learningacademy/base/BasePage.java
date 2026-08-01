package com.learningacademy.base;
import com.learningacademy.utils.ConfigReader;
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
    private boolean isHeadless;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.isHeadless = Boolean.parseBoolean(ConfigReader.getProperty("headless"));
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
                wait.until(ExpectedConditions.refreshed(
                        ExpectedConditions.elementToBeClickable(locator)
                ));

        element.clear();

        element.sendKeys(text);

    }

    /**
     * Returns true if the element is displayed.
     */
    protected boolean isDisplayed(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (TimeoutException e) {
            logger.warn("Element not visible: {}", locator);
            return false;
        }
    }
    protected void waitForUrlContains(String value) {

        wait.until(ExpectedConditions.urlContains(value));

    }
    public void maximizeWindow() {
        if (!isHeadlessMode()) { // أضف هذه الدالة للتحقق
            driver.manage().window().maximize();
        } else {
            // في وضع Headless، قم بتعيين حجم معقول
            driver.manage().window().setSize(new Dimension(1920, 1080));
        }
    }
    private boolean isHeadlessMode() {
        // يمكنك قراءة القيمة من ملف الخصائص
        return Boolean.parseBoolean(ConfigReader.getProperty("headless"));
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
