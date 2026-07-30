package com.learningacademy.testcases;

import com.learningacademy.Base.BaseTest;
import com.learningacademy.dataProviders.UserDataProvider;
import com.learningacademy.models.User;
import com.learningacademy.models.Users;
import com.learningacademy.pages.DashboardPage;
import com.learningacademy.pages.LoginPage;
import com.learningacademy.utils.ConfigReader;
import com.learningacademy.utils.ScreenshotUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @BeforeSuite
    public void cleanScreenshotsFolder() {
        ScreenshotUtil.cleanFolder();
    }
    @Test(dataProvider = "validUsers",
            dataProviderClass = UserDataProvider.class)
    public void validUserShouldLoginSuccessfully(User user) {

        DashboardPage dashboardPage =
                openLoginPage().login(user);

        Assert.assertTrue(
                dashboardPage.isAtDashboardPage()
        );
    }
    @Test
    public void loginShouldFailWithInvalidPassword() {

        openLoginPage().login(Users.INVALID_PASSWORD);
        String actual = pages.loginPage().getLoginErrorMessage();
        String expected = ConfigReader.getLoginErrorMessage();

        System.out.println("Actual   = [" + actual + "]");
        System.out.println("Expected = [" + expected + "]");

        Assert.assertEquals(actual, expected);
        Assert.assertTrue(
                pages.loginPage().isLoginErrorDisplayed()
        );

        Assert.assertEquals(
                pages.loginPage().getLoginErrorMessage(),
                ConfigReader.getLoginErrorMessage()
        );
    }

    @Test
    public void loginShouldFailWithEmptyCredentials() {
        openLoginPage().clickLoginButton();
        Assert.assertTrue(
                pages.loginPage().isLoginErrorDisplayed()
        );
    }
    @Test
    public void loginShouldFailWithInvalidCredentials() {

        openLoginPage().login(Users.INVALID_CREDENTIALS);

        Assert.assertTrue(
                pages.loginPage().isLoginErrorDisplayed()
        );

        Assert.assertEquals(
                pages.loginPage().getLoginErrorMessage(),
                ConfigReader.getLoginErrorMessage()
        );
    }
    @Test
    public void loginShouldFailWithEmptyUsername() {

        openLoginPage().login("", Users.STUDENT.getPassword());

        Assert.assertTrue(
                pages.loginPage().isLoginErrorDisplayed()
        );

        Assert.assertEquals(
                pages.loginPage().getLoginErrorMessage(),
                ConfigReader.getLoginErrorMessage()
        );
    }
    @Test
    public void givenEmptyPasswordWhenLoginThenValidationMessageShouldBeDisplayed() {

        LoginPage loginPage = openLoginPage();

        loginPage.login(Users.STUDENT.getUsername(), "");

        Assert.assertEquals(
                loginPage.getLoginErrorMessage(),
                ConfigReader.getLoginErrorMessage(),
                "Validation message should be displayed for empty password."
        );
    }

}

