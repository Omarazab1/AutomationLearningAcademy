package com.learningacademy.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class ScreenshotUtil  {
    private static final Logger logger =
            LoggerFactory.getLogger(ScreenshotUtil.class);

    public static File takeScreenshot(WebDriver driver, String testName) {

        File sourceFile =
                ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        File destinationFile =
                new File("screenshots/" + testName + ".png");

        try {

            Files.copy(
                    sourceFile.toPath(),
                    destinationFile.toPath(),
                    StandardCopyOption.REPLACE_EXISTING
            );

        } catch (IOException e) {
            e.printStackTrace();
        }

        return destinationFile;
    }
    public static void cleanFolder() {

        File folder = new File("screenshots");

        if (!folder.exists()) {
            return;
        }

        File[] files = folder.listFiles();

        if (files == null) {
            return;
        }

        for (File file : files) {

            if (file.isFile()) {

                boolean deleted = file.delete();

                if (!deleted) {
                    logger.warn("Failed to delete screenshot {}", file.getName());
                    System.out.println("Failed to delete: " + file.getName());
                }
            }
        }
    }
}
