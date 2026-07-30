package com.learningacademy.testcases;

import com.learningacademy.base.BaseTest;
import com.learningacademy.listeners.RetryListener;
import com.learningacademy.listeners.ScreenshotListener;
import com.learningacademy.models.Users;
import com.learningacademy.pages.DashboardPage;
import com.learningacademy.pages.HomePage;
import com.learningacademy.utils.ScreenshotUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners({
        ScreenshotListener.class,
        RetryListener.class
})

public class LogoutTest extends BaseTest {
    @BeforeSuite
    public void cleanScreenshotsFolder() {
        ScreenshotUtil.cleanFolder();
    }
    @Test
    public void userShouldLogoutSuccessfully() {

        DashboardPage dashboardPage =
                openLoginPage().login(Users.ADMIN);

        HomePage homePage =
                dashboardPage.logout();

        Assert.assertTrue(
                homePage.isAtHomePage()
        );
    }
}
