package com.learningacademy.testcases;
import com.learningacademy.base.BaseTest;
import com.learningacademy.models.Users;
import com.learningacademy.pages.ActivityPage;
import com.learningacademy.utils.ScreenshotUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class ActivityTest extends BaseTest {
    @BeforeSuite
    public void cleanScreenshotsFolder() {
        ScreenshotUtil.cleanFolder();
    }
    @Test
    public void givenStudentWhenOpenFirstActivityThenActivityPageShouldBeDisplayed() {
        ActivityPage activityPage =
                openLoginPage()
                        .login(Users.STUDENT)
                        .openCoursesPage()
                        .openCourse("The Impressionists")
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
    @Test
    public void givenStudentWhenMarksActivityButtonIsDone(){
        ActivityPage activityPage =
                openLoginPage()
                        .login(Users.STUDENT)
                        .openCoursesPage()
                        .openCourse("The Impressionists")
                        .openFirstActivity()
                        .clickMarkAsDoneButton();
        Assert.assertTrue(activityPage.isActivityButtonDone());
    }
}

