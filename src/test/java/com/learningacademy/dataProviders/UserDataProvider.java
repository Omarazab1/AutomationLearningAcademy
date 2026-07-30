package com.learningacademy.dataProviders;

import com.learningacademy.models.Users;
import org.testng.annotations.DataProvider;

public class UserDataProvider {
    @DataProvider(name = "validUsers")
    public static Object[][] validUsers() {

        return new Object[][]{
                {Users.ADMIN},
                {Users.STUDENT},
                {Users.LECTURER},
                {Users.PRIVACY_OFFICER},
                {Users.LEARNING_SUPPORT_TUTOR}

        };
}}
