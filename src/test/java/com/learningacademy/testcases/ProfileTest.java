package com.learningacademy.testcases;

import com.learningacademy.base.BaseTest;
import com.learningacademy.models.Users;
import com.learningacademy.pages.ProfilePage;
import com.learningacademy.utils.ScreenshotUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ProfileTest extends BaseTest {
    @BeforeSuite
    public void cleanScreenshotsFolder() {
        ScreenshotUtil.cleanFolder();
    }

    @Test(
            description = "Verify that a logged-in user can open the profile page successfully."
    )
    public void userShouldOpenProfilePageSuccessfully() {

        ProfilePage profilePage =
                openLoginPage()
                        .login(Users.STUDENT)
                        .openProfilePage();

        Assert.assertTrue(profilePage.isAtProfilePage());
    }
    @Test(description = "Verify that the user's full name is displayed.")
    public void profileShouldDisplayUserName() {

        ProfilePage profilePage =
                openLoginPage()
                        .login(Users.STUDENT)
                        .openProfilePage();

        Assert.assertTrue(profilePage.isProfileNameDisplayed());

        Assert.assertEquals(
                profilePage.getProfileName(),
                "Barbara Gardner"
        );
    }
    @Test(description = "Verify that the profile picture is displayed.")
    public void profileShouldDisplayUserAvatar() {

        ProfilePage profilePage =
                openLoginPage()
                        .login(Users.STUDENT)
                        .openProfilePage();

        Assert.assertTrue(
                profilePage.isProfileImageDisplayed()
        );
    }
    @Test(description = "Verify that the user's email is displayed.")
    public void profileShouldDisplayUserEmail() {

        ProfilePage profilePage =
                openLoginPage()
                        .login(Users.STUDENT)
                        .openProfilePage();

        Assert.assertTrue(
                profilePage.isProfileEmailDisplayed()
        );
    }
   @Test(description = "Verify that Edit profile button is displayed.")
    public void profileShouldDisplayEditProfileButton() {

        ProfilePage profilePage =
                openLoginPage()
                        .login(Users.STUDENT)
                        .openProfilePage();

        Assert.assertTrue(
                profilePage.isEditProfileButtonDisplayed()
        );
    }
    @Test(description = "Verify that Edit profile page opens successfully.")
    public void userShouldOpenEditProfilePage() {

        ProfilePage profilePage =
                openLoginPage()
                        .login(Users.STUDENT)
                        .openProfilePage()
                        .openEditProfile();

        Assert.assertTrue(
                profilePage.isAtEditProfilePage()
        );
    }
}
