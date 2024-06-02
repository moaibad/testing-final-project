package com.a1.apitesting.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.awt.*;
import java.io.File;
import java.io.IOException;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/apitesting",
        glue = "com.a1.apitesting.stepdefinitions",
        plugin = { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }
)

public class ApiTestRunner {

    @AfterClass
    public static void openHtmlReport() {
        try {
            Desktop.getDesktop().browse(new File("test-output/report.html").toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}