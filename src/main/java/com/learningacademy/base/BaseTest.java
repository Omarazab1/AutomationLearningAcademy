package com.learningacademy.base;
import com.learningacademy.utils.ConfigReader;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import com.learningacademy.driver.DriverFactory;

public class BaseTest {
        @BeforeMethod
        public void setUp() {
            DriverFactory.initDriver();
            DriverFactory.getDriver().get(ConfigReader.getBaseUrl());
        }
        @AfterMethod
        public void tearDown() {
            DriverFactory.quitDriver();
        }
    }

