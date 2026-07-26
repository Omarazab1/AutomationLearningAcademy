package com.learningacademy.pages;

import com.learningacademy.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyCoursesPage extends BasePage {
    private final By pageTitle =
            By.xpath("//h1[text()='My courses']");

    private final By createCourseButton =
            By.cssSelector("form[action*='course/edit.php'] button");

    private final By manageCoursesButton =
            By.cssSelector("form[action*='course/management.php'] button");

    private final By courseCard =
            By.cssSelector("div.course-card");
    private final By firstCourse = By.cssSelector(".course-card a");
    public MyCoursesPage(WebDriver driver) {
        super(driver);
    }


    // Actions
    public CoursePage openFirstCourse() {
        click(firstCourse);
        return new CoursePage(driver);
    }
    // Validations
    public boolean isAtCoursePage() {
        return getCurrentUrl().contains("/my/courses.php");
    }

    public boolean isPageDisplayed() {
        return isDisplayed(pageTitle);
    }

    public boolean isCreateCourseDisplayed() {
        return isDisplayed(createCourseButton);
    }

    public boolean isManageCourseDisplayed() {
        return isDisplayed(manageCoursesButton);
    }

    public boolean isCourseDisplayed() {
        return isDisplayed(courseCard);
    }
    }
