package com.a1.webtesting.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDetailPage {
    WebDriver driver;

    By productName = By.cssSelector(".inventory_details_name.large_size");
    By productDescription = By.cssSelector(".inventory_details_desc.large_size");
    By productPrice = By.cssSelector(".inventory_details_price");
    By productImage = By.cssSelector(".inventory_details_img");

    By addToCartButton = By.id("add-to-cart");
    By removeButton = By.id("remove");

    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean is_product_name_visible(){
        return driver.findElement(productName).isDisplayed();
    }

    public boolean is_product_description_visible(){
        return driver.findElement(productDescription).isDisplayed();
    }

    public boolean is_product_price_visible(){
        return driver.findElement(productPrice).isDisplayed();
    }

    public boolean is_product_image_visible(){
        return driver.findElement(productImage).isDisplayed();
    }

    public void click_add_to_cart_button(){
        driver.findElement(addToCartButton).click();
    }

    public boolean is_add_to_cart_button_changed_to_remove(){
        return driver.findElement(removeButton).isDisplayed();
    }

    public void click_remove_button(){
        driver.findElement(removeButton).click();
    }

    public boolean is_remove_button_changed_to_add_to_cart(){
        return driver.findElement(addToCartButton).isDisplayed();
    }

}
