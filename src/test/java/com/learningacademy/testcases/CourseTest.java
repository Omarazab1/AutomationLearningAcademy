package com.learningacademy.testcases;

import com.learningacademy.Base.BaseTest;
import com.learningacademy.models.Users;
import com.learningacademy.pages.CoursePage;
import com.learningacademy.pages.MyCoursesPage;
import com.learningacademy.pages.DashboardPage;
import com.learningacademy.utils.ScreenshotUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CourseTest extends BaseTest {
    @BeforeSuite
    public void cleanScreenshotsFolder() {
        ScreenshotUtil.cleanFolder();
    }
    @Test
    public void givenManagerWhenOpenCoursesThenCoursePageShouldBeDisplayed() {

        DashboardPage dashboardPage =
                openLoginPage().login(Users.ADMIN);

        MyCoursesPage myCoursesPage =
                dashboardPage.openCoursesPage();

        Assert.assertTrue(myCoursesPage.isAtCoursePage());

        Assert.assertTrue(myCoursesPage.isPageDisplayed());

        Assert.assertTrue(myCoursesPage.isManageCourseDisplayed());

        Assert.assertTrue(myCoursesPage.isCreateCourseDisplayed());
    }
    @Test
    public void givenStudentWhenOpenCoursesThenAvailableCoursesShouldBeDisplayed() {

        // Arrange
        DashboardPage dashboardPage =
                openLoginPage().login(Users.STUDENT);

        // Act
        MyCoursesPage myCoursesPage =
                dashboardPage.openCoursesPage();

        // Assert
        Assert.assertTrue(
                myCoursesPage.isAtCoursePage()
        );

        Assert.assertTrue(
                myCoursesPage.isPageDisplayed()
        );

        Assert.assertTrue(
                myCoursesPage.isCourseDisplayed()
        );

        Assert.assertFalse(
                myCoursesPage.isCreateCourseDisplayed()
        );

        Assert.assertFalse(
                myCoursesPage.isManageCourseDisplayed()
        );
    }
    @Test
    public void studentShouldOpenCourseSuccessfully() {

        DashboardPage dashboard =
                openLoginPage().login(Users.STUDENT);

        MyCoursesPage myCourses =
                dashboard.openCoursesPage();

        CoursePage coursePage =
                myCourses.openCourse("The Impressionists");
        Assert.assertTrue(coursePage.isCoursePageDisplayed());
        Assert.assertTrue(coursePage.isCourseTitleDisplayed());

    }
    @Test
    public void givenStudentWhenOpenCourseThenCourseContentShouldBeDisplayed() {

        DashboardPage dashboard =
                openLoginPage().login(Users.STUDENT);

        MyCoursesPage myCourses =
                dashboard.openCoursesPage();

        CoursePage coursePage =
                myCourses.openCourse("The Impressionists");

        Assert.assertTrue(
                coursePage.isCoursePageDisplayed(),
                "Course page should be displayed."
        );

        Assert.assertTrue(
                coursePage.isFirstActivityDisplayed(),
                "First activity should be displayed."
        );
    }
    @Test
    public void givenStudentWhenNavigateBackFromCourseThenMyCoursesPageShouldBeDisplayed() {

        MyCoursesPage myCoursesPage =
                openLoginPage()
                        .login(Users.STUDENT)
                        .openCoursesPage();

        CoursePage coursePage =
                myCoursesPage.openCourse("The Impressionists");

        coursePage.goBack();

        Assert.assertTrue(
                myCoursesPage.isAtCoursePage(),
                "User should be redirected back to My Courses page."
        );
    }
    @Test
    public void givenStudentWhenOpenCourseThenSectionsShouldBeDisplayed() {

        CoursePage coursePage =
                openLoginPage()
                        .login(Users.STUDENT)
                        .openCoursesPage()
                        .openCourse("The Impressionists");

        Assert.assertTrue(coursePage.isGeneralSectionDisplayed());

        Assert.assertTrue(coursePage.isBackgroundSectionDisplayed());

        Assert.assertTrue(coursePage.isBackgroundExpanded());
    }
    @Test
    public void givenStudentWhenOpenCourseThenActivitiesShouldBeDisplayed() {

        CoursePage coursePage =
                openLoginPage()
                        .login(Users.STUDENT)
                        .openCoursesPage()
                        .openCourse("The Impressionists");

        Assert.assertTrue(
                coursePage.getActivitiesCount() > 0,
                "Activities should be displayed."
        );
    }
    @Test
    public void givenStudentWhenOpenCourseThenCorrectCourseTitleShouldBeDisplayed() {

        CoursePage coursePage =
                openLoginPage()
                        .login(Users.STUDENT)
                        .openCoursesPage()
                        .openCourse("The Impressionists");

        Assert.assertEquals(
                coursePage.getCourseTitle(),
                "The Impressionists"
        );
    }
    @Test
    public void givenStudentWhenOpenCourseThenUrlShouldBeCorrect() {

        CoursePage coursePage =
                openLoginPage()
                        .login(Users.STUDENT)
                        .openCoursesPage()
                        .openCourse("The Impressionists");

        Assert.assertTrue(coursePage.isCoursePageDisplayed());
    }
    @Test(description = "Verify that a student can search for a course using the full course name.")
    public void studentShouldSearchCourseByFullName() {

        MyCoursesPage myCoursesPage =
                openLoginPage()
                        .login(Users.STUDENT)
                        .openCoursesPage();

        myCoursesPage.searchCourse("The Impressionists");

        Assert.assertTrue(
                myCoursesPage.isCourseDisplayed("The Impressionists"),
                "The searched course should be displayed."
        );
    }
    @Test(description = "Verify that a student can search for a course using the partial course name.")
    public void studentShouldSearchCourseByPartialName() {

        MyCoursesPage myCoursesPage =
                openLoginPage()
                        .login(Users.STUDENT)
                        .openCoursesPage();

        myCoursesPage.searchCourse("Impress");

        Assert.assertTrue(
                myCoursesPage.isCourseDisplayed("The Impressionists"),
                "Course should be found using partial name."
        );
    }


}
