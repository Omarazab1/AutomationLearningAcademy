package com.learningacademy.pages;

import com.learningacademy.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ActivityPage extends BasePage {
    private final By activityTitle =
            By.xpath("//h1[contains(text(),'A Guide to Impressionism from the National Gallery')]");
    private final By activityIcon =
            By.cssSelector(".activityicon");

    private final By breadcrumb =
            By.cssSelector(".breadcrumb");

    private final By markAsDoneButton =
            By.xpath("//button[contains(.,'Mark as done')]");
    private final By doneButton = By.cssSelector("button.btn-subtle-success[data-cmid='729']");
    public ActivityPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAtActivityPage() {
        return getCurrentUrl().contains("/mod/url/view.php");
    }
    public boolean isActivityTitleDisplayed() {
        return isDisplayed(activityTitle);
    }

    public String getActivityTitle() {
        return getText(activityTitle);
    }
    public boolean isActivityIconDisplayed() {
        return isDisplayed(activityIcon);
    }
   public ActivityPage clickMarkAsDoneButton(){
       logger.info("Marking activity as done");
        click(markAsDoneButton);
        return this;
   }
    public boolean isActivityButtonDone() {
        return getText(doneButton).trim().equals("Done");
    }
    public boolean isBreadcrumbDisplayed() {
        return isDisplayed(breadcrumb);
    }
    public boolean isMarkAsDoneButtonDisplayed() {
        return isDisplayed(markAsDoneButton);
    }
}
