package com.a1.webtesting.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class LogoutPage {
    WebDriver driver;

    By sidebarMenu = By.id("react-burger-menu-btn");
    By logoutButton = By.id("logout_sidebar_link");

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openSidebarMenu(){
        driver.findElement(sidebarMenu).click();
    }

    public void clickLogoutButton(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.findElement(logoutButton).click();
    }
}