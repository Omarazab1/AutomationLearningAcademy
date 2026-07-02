package com.learningacademy.pages;

import com.learningacademy.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {

        @FindBy(id = "user-menu-toggle")
        private WebElement profileMenu;

        public boolean isDashboardDisplayed() {
            return isDisplayed(profileMenu);
        }
    }

