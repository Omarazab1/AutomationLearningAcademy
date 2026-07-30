package com.learningacademy.listeners;

import com.learningacademy.driver.DriverFactory;
import com.learningacademy.utils.ScreenshotUtil;
import io.qameta.allure.Attachment;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ScreenshotListener implements ITestListener {
    private static final Logger logger =
            LoggerFactory.getLogger(ScreenshotListener.class);
    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = DriverFactory.getDriver();

        File screenshot =
                ScreenshotUtil.takeScreenshot(
                        driver,
                        result.getName()
                );

        try {

            attachScreenshot(screenshot);

        } catch (IOException e) {

            logger.error("Unable to load config.properties", e);
        }

    }

    @Attachment(
            value = "Failure Screenshot",
            type = "image/png"
    )
    public byte[] attachScreenshot(File screenshot)
            throws IOException {

        return Files.readAllBytes(screenshot.toPath());

    }

}