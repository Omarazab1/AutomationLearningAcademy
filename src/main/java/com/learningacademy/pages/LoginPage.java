package com.learningacademy.pages;

import com.learningacademy.base.BasePage;
import com.learningacademy.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LoginPage extends BasePage {

    // Locators
    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("loginbtn");
    private final By loginErrorMessage = By.id("loginerrormessage");
    // Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Actions
    public DashboardPage login(User user) {
        logger.info("Logging in as {}", user.getUsername());
        enterText(usernameField, user.getUsername());
        enterText(passwordField, user.getPassword());
        click(loginButton);

        return new DashboardPage(driver);
    }
    public LoginPage login(String username, String password) {

        enterText(usernameField, username);
        enterText(passwordField, password);
        click(loginButton);

        return this;
    }

    public void enterUsername(String username) {
        enterText(usernameField, username);
    }

    public void enterPassword(String password) {
        enterText(passwordField, password);
    }

    public void clickLoginButton() {
        click(loginButton);
    }

    // Validations
    public boolean isLoginErrorDisplayed() {
        return isDisplayed(loginErrorMessage);
    }

    public String getLoginErrorMessage() {
        return getText(loginErrorMessage)
                .replace("\n", " ")
                .replace("\r", "")
                .trim();
    }

    public String getPageTitleText() {
        return getPageTitle();
    }
}
