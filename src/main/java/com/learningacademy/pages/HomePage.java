package com.learningacademy.pages;

import com.learningacademy.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage  extends BasePage {
    private final By loginLink =
            By.cssSelector("a[href*='login/index.php']");
    public HomePage(WebDriver driver) {
        super(driver);
    }
    public LoginPage openLoginPage() {
        click(loginLink);
        return new LoginPage(driver);
    }

}
