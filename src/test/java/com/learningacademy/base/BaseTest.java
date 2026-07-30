package com.learningacademy.base;
import com.learningacademy.managers.PageManager;
import com.learningacademy.pages.LoginPage;
import com.learningacademy.utils.AllureUtil;
import com.learningacademy.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import com.learningacademy.driver.DriverFactory;
import org.testng.annotations.BeforeSuite;


public class BaseTest {
    protected WebDriver driver;
    protected PageManager pages;
    protected LoginPage openLoginPage() {
        return pages.homePage().openLoginPage();
    }
    @BeforeSuite
    public void cleanAllureResults() {
        AllureUtil.cleanResults();
    }
    @BeforeMethod
        public void setUp() {
        DriverFactory.initDriver();
        driver = DriverFactory.getDriver();
        driver.get(ConfigReader.getBaseUrl());
        pages = new PageManager(driver);
        }
        @AfterMethod
        public void tearDown() {
            DriverFactory.quitDriver();
        }
    }

