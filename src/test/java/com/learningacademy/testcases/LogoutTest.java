package com.learningacademy.testcases;

import com.learningacademy.base.BaseTest;
import com.learningacademy.models.Users;
import com.learningacademy.pages.DashboardPage;
import com.learningacademy.pages.HomePage;
import com.learningacademy.utils.ScreenshotUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

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
