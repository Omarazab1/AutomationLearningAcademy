package com.learningacademy.pages;

import com.learningacademy.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CoursePage extends BasePage {
    private final By courseTitle =
            By.xpath("//h1[contains(text(),'The Impressionists')]");

    public CoursePage(WebDriver driver) {
        super(driver);
    }
    public boolean isCoursePageDisplayed() {
        return getCurrentUrl().contains("/course/view.php");
    }

    public boolean isCourseTitleDisplayed() {
        return isDisplayed(courseTitle);
    }

    public String getCourseTitle() {
        return getText(courseTitle);
    }
}
