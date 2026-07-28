package com.learningacademy.testcases;
import com.learningacademy.base.BaseTest;
import com.learningacademy.models.Users;
import com.learningacademy.pages.ActivityPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ActivityTest extends BaseTest {

    @Test
    public void givenStudentWhenOpenFirstActivityThenActivityPageShouldBeDisplayed() {
        ActivityPage activityPage =
                openLoginPage()
                        .login(Users.STUDENT)
                        .openCoursesPage()
                        .openFirstCourse()
                        .openFirstActivity();

        Assert.assertTrue(activityPage.isAtActivityPage());
        Assert.assertTrue(activityPage.isActivityTitleDisplayed());
        Assert.assertEquals(
                activityPage.getActivityTitle(),
                "A Guide to Impressionism from the National Gallery"
        );
        Assert.assertTrue(activityPage.isMarkAsDoneButtonDisplayed());
        Assert.assertTrue(activityPage.isBreadcrumbDisplayed());
        Assert.assertTrue(activityPage.isActivityIconDisplayed());
        Assert.assertTrue(activityPage.isMarkAsDoneButtonDisplayed());
    }
}

