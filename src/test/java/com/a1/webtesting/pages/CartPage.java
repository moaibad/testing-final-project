package com.a1.webtesting.pages;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {
    WebDriver driver;

    By products = By.className("inventory_item_name");
    By continueShoppingButton = By.id("continue-shopping");
    By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public Integer count_product_in_the_cart(){
        List<WebElement> elements = driver.findElements(products);
        return elements.size();
    }

    public void click_continue_shopping_button(){
        driver.findElement(continueShoppingButton).click();
    }

    public void click_checkout_button(){
        driver.findElement(checkoutButton).click();
    }

}
