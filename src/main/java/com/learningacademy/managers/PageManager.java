package com.learningacademy.managers;

import com.learningacademy.pages.*;
import org.openqa.selenium.WebDriver;

public class PageManager {
        private final WebDriver driver;
        private LoginPage loginPage;
        private DashboardPage dashboardPage;
        private HomePage homePage;
        private MyCoursesPage myCoursesPage;
        private CoursePage coursePage;
        private ActivityPage activityPage;
        public PageManager(WebDriver driver) {
            this.driver = driver;
        }

        public LoginPage loginPage() {

            if (loginPage == null) {
                loginPage = new LoginPage(driver);
            }

            return loginPage;
        }
        public HomePage homePage() {

         if (homePage == null) {
            homePage = new HomePage(driver);
         }

         return homePage;
     }
        public DashboardPage dashboardPage() {

            if (dashboardPage == null) {
                dashboardPage = new DashboardPage(driver);
            }

            return dashboardPage;
        }
    public MyCoursesPage MyCoursePage() {
        if (myCoursesPage == null) {
            myCoursesPage = new MyCoursesPage(driver);
        }
        return myCoursesPage;
    }

    public CoursePage coursePage() {
        if (coursePage == null) {
            coursePage = new CoursePage(driver);
        }
        return coursePage;
    }
    public ActivityPage activityPage() {
            if (activityPage == null) {
                activityPage = new ActivityPage(driver);
            }
            return activityPage;
    }
}

