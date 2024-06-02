package com.a1.webtesting.pages;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MenuPage {
    WebDriver driver;

    By menuButton = By.id("react-burger-menu-btn");

    By inventoryButton = By.id("inventory_sidebar_link");
    By aboutButton = By.id("about_sidebar_link");
    By logoutButton = By.id("logout_sidebar_link");
    By resetButton = By.id("reset_sidebar_link");
    By closeButton = By.id("react-burger-cross-btn");

    public MenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public void click_menu_button(){
        driver.findElement(menuButton).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean show_options(DataTable data){
        List<String> expectedOptions = data.asList(String.class);

        List<String> actualOptions = new ArrayList<>();
        actualOptions.add(driver.findElement(inventoryButton).getText());
        actualOptions.add(driver.findElement(aboutButton).getText());
        actualOptions.add(driver.findElement(logoutButton).getText());
        actualOptions.add(driver.findElement(resetButton).getText());

        return expectedOptions.equals(actualOptions);
    }

    public void click_about_button(){
        driver.findElement(aboutButton).click();
    }

    public void click_close_button(){
        driver.findElement(closeButton).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
