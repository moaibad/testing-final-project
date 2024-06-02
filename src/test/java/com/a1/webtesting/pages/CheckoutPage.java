package com.a1.webtesting.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    WebDriver driver;

    By firstNameField = By.id("first-name");
    By lastNameField = By.id("last-name");
    By postalCodeField = By.id("postal-code");
    By continueButton = By.id("continue");
    By cancelButton = By.id("cancel");
    By finishButton = By.id("finish");


    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enter_first_name(String input) {
        driver.findElement(firstNameField).sendKeys(input);
    }

    public void enter_last_name(String input) {
        driver.findElement(lastNameField).sendKeys(input);
    }

    public void enter_postal_code(String input) {
        driver.findElement(postalCodeField).sendKeys(input);
    }

    public void click_continue_button(){
        driver.findElement(continueButton).click();
    }

    public void click_cancel_button(){
        driver.findElement(cancelButton).click();
    }

    public void click_finish_button(){
        driver.findElement(finishButton).click();
    }


}
