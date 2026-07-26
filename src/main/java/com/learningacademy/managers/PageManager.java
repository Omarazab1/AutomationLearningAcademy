package com.learningacademy.managers;

import com.learningacademy.pages.DashboardPage;
import com.learningacademy.pages.HomePage;
import com.learningacademy.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class PageManager {
        private final WebDriver driver;
        private LoginPage loginPage;
        private DashboardPage dashboardPage;
        private HomePage homePage;
        public PageManager(WebDriver driver) {
            this.driver = driver;
        }

        public LoginPage loginPage() {

            if (loginPage == null) {
                loginPage = new LoginPage(driver);
            }

            return loginPage;
        }
    public HomePage homePage() {

        if (homePage == null) {
            homePage = new HomePage(driver);
        }

        return homePage;
    }
        public DashboardPage dashboardPage() {

            if (dashboardPage == null) {
                dashboardPage = new DashboardPage(driver);
            }

            return dashboardPage;
        }
    }

