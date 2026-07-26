package com.learningacademy.testcases;

import com.learningacademy.base.BaseTest;
import com.learningacademy.models.Users;
import com.learningacademy.pages.CoursePage;
import com.learningacademy.pages.MyCoursesPage;
import com.learningacademy.pages.DashboardPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CourseTest extends BaseTest {
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
                myCourses.openFirstCourse();
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
                myCourses.openFirstCourse();

        Assert.assertTrue(
                coursePage.isCoursePageDisplayed(),
                "Course page should be displayed."
        );

        Assert.assertTrue(
                coursePage.isFirstActivityDisplayed(),
                "First activity should be displayed."
        );
    }
}
