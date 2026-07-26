package com.learningacademy.pages;

import com.learningacademy.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {

    // Locators
    private final By userMenu = By.id("user-menu-toggle");
    private final By dashboardTitle = By.xpath("//h1[text()='Dashboard']");
    private final By logoutButton = By.cssSelector("a[href*='logout.php']");

    // Constructor
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    // Actions
    public void openUserMenu() {
        click(userMenu);
    }

//PageChaining
    public LoginPage logout() {
        openUserMenu();
        click(logoutButton);
        return new LoginPage(driver);
    }
    public boolean isAtDashboardPage() {
        return isUserMenuDisplayed();
    }


    // Validations
    public boolean isUserMenuDisplayed() {
        return isDisplayed(userMenu);
    }

    public boolean isDashboardDisplayed() {
        return isDisplayed(dashboardTitle);
    }

    public String getDashboardTitle() {
        return getText(dashboardTitle);
    }
}