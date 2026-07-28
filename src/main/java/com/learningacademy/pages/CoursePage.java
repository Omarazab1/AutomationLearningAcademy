package com.learningacademy.pages;

import com.learningacademy.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CoursePage extends BasePage {
    private final By courseTitle =
            By.xpath("//h1[contains(text(),'The Impressionists')]");
    private final By generalSection =
            By.xpath("//h3[contains(text(),'General')]");
    private final By firstActivity =
            By.xpath("//li[@id='section-1']//div[@class='activityname']//a");
    public CoursePage(WebDriver driver) {
        super(driver);
    }
    public boolean isCoursePageDisplayed() {
        return getCurrentUrl().contains("/course/view.php");
    }

    public boolean isCourseTitleDisplayed() {
        return isDisplayed(courseTitle);
    }
    public boolean isFirstActivityDisplayed() {
        return isDisplayed(firstActivity);
    }
    public ActivityPage openFirstActivity() {
        scrollTo(firstActivity);
        wait.until(ExpectedConditions.elementToBeClickable(firstActivity));
        click(firstActivity);
        return new ActivityPage(driver);
    }
    public String getCourseTitle() {
        return getText(courseTitle);
    }
}
