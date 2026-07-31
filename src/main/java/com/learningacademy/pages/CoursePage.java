package com.learningacademy.pages;

import com.learningacademy.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CoursePage extends BasePage {
    private final By courseTitle =
            By.xpath("//h1[contains(text(),'The Impressionists')]");
    private final By firstActivity =
            By.xpath("//li[@id='section-1']//div[@class='activityname']//a");
    private final By generalSection =
            By.cssSelector("li[data-sectionname='General']");
    private final By backgroundSection =
            By.cssSelector("li[data-sectionname='Background']");
    private final By backgroundContent =
            By.cssSelector("li[data-sectionname='Background'] div.content.show");
    private final By activities =
            By.cssSelector("li[data-sectionname='Background'] li.activity");

    public CoursePage(WebDriver driver) {
        super(driver);
    }
    public int getActivitiesCount() {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(activities)
        );

        return finds(activities).size();
    }
    public boolean isGeneralSectionDisplayed() {
        return isDisplayed(generalSection);
    }
    public boolean isBackgroundSectionDisplayed() {
        return isDisplayed(backgroundSection);
    }

    public boolean isBackgroundExpanded() {
        return isDisplayed(backgroundContent);
    }
    public boolean isCoursePageDisplayed() {

        try {

            wait.until(ExpectedConditions.urlContains("/course/view.php"));

            return true;

        } catch (TimeoutException e) {

            return false;

        }

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
        logger.info("Open firstActivity Successfully");
        click(firstActivity);
        return new ActivityPage(driver);
    }
    public String getCourseTitle() {
        return getText(courseTitle);
    }
}
