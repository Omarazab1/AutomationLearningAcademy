package com.learningacademy.pages;

import com.learningacademy.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ProfilePage extends BasePage {
    private final By profileName =
            By.cssSelector("h1.h2.mb-0");

    private final By profileImage =
            By.cssSelector("img.userpicture");

    private final By profileEmail =
            By.cssSelector("a[href^='mailto:']");

    private final By breadcrumb =
            By.cssSelector(".breadcrumb");

    private final By editProfileButton =
            By.cssSelector("a[href*='user/edit.php']");
    public ProfilePage(WebDriver driver) {
        super(driver);
    }
    public boolean isAtProfilePage() {
        logger.info("Verifying Profile Page");
        return getCurrentUrl().contains("/user/profile.php");
    }
    public boolean isProfileNameDisplayed() {
        return isDisplayed(profileName);
    }
    public String getProfileName() {
        return getText(profileName);
    }
    public boolean isProfileImageDisplayed() {
        return isDisplayed(profileImage);
    }
    public boolean isProfileEmailDisplayed() {
        return isDisplayed(profileEmail);
    }
    public boolean isEditProfileButtonDisplayed() {
        return isDisplayed(editProfileButton);
    }
    public ProfilePage openEditProfile() {
        click(editProfileButton);
        return this;
    }
    public boolean isAtEditProfilePage() {
        logger.info("Verifying Edit Profile Page");
        return getCurrentUrl().contains("/user/edit.php");
    }
}
