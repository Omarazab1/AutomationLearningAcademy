package com.learningacademy.utils;


import java.io.File;

public class AllureUtil {

        public static void cleanResults() {
            File folder = new File("allure-results");

            if (!folder.exists()) {
                return;
            }

            for (File file : folder.listFiles()) {
                file.delete();
            }
        }
    }

