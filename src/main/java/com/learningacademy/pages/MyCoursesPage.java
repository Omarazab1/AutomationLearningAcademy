package com.learningacademy.pages;

import com.learningacademy.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MyCoursesPage extends BasePage {
    private final By pageTitle =
            By.xpath("//h1[text()='My courses']");

    private final By createCourseButton =
            By.cssSelector("form[action*='course/edit.php'] button");

    private final By manageCoursesButton =
            By.cssSelector("form[action*='course/management.php'] button");
    private final By courseCards =
            By.cssSelector("div.card.course-card");
    private final By courseCard =
            By.cssSelector("div.course-card");
    private final By searchInput =
            By.cssSelector("input[data-action='search']");
    public MyCoursesPage(WebDriver driver) {
        super(driver);
    }
    private List<WebElement> getCourseCards() {
        return driver.findElements(courseCards);
    }

    // Actions
    public CoursePage openCourse(String courseName) {

        for (WebElement card : getCourseCards()) {

            if (card.getText().contains(courseName)) {

                card.findElement(By.tagName("a")).click();

                return new CoursePage(driver);
            }
        }

        throw new RuntimeException("Course not found: " + courseName);
    }
    public MyCoursesPage searchCourse(String courseName) {

        enterText(searchInput, courseName);
        wait.until(driver ->
                finds(courseCards).size() != 10
        );
        return this;
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
    public boolean isCourseDisplayed(String courseName) {

        for (WebElement course : finds(courseCards)) {

            if (course.getText().contains(courseName)) {
                return true;
            }
        }

        return false;
    }
    public int getCoursesCount() {

        int count = 0;

        for (WebElement course : finds(courseCards)) {

            if (course.isDisplayed()) {
                count++;
            }
        }

        return count;
    }
    }
