package com.a1.webtesting.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
public class DashboardPage {
    WebDriver driver;

    By addToCartSauceLabsBackpackButton = By.id("add-to-cart-sauce-labs-backpack");
    By removeSauceLabsBackpackButton = By.id("remove-sauce-labs-backpack");

    By addToCartSauceLabsBikeLightButton = By.id("add-to-cart-sauce-labs-bike-light");
    By removeSauceLabsBikeLightButton = By.id("remove-sauce-labs-bike-light");

    By addToCartSauceLabsBoltTShirt = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    By removeSauceLabsBoltTShirt = By.id("remove-sauce-labs-bolt-t-shirt");

    By addToCartSauceLabsFleeceJacket = By.id("add-to-cart-sauce-labs-fleece-jacket");
    By removeSauceLabsFleeceJacket = By.id("remove-sauce-labs-fleece-jacket");

    By addToCartSauceLabsOnesie = By.id("add-to-cart-sauce-labs-onesie");
    By removeSauceLabsOnesie= By.id("remove-sauce-labs-onesie");

    By addToCartSauceLabsRedTShirt = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");
    By removeSauceLabsRedTShirt = By.id("remove-test.allthethings()-t-shirt-(red)");

    By cartNumber = By.className("shopping_cart_badge");
    By productName = By.id("item_4_title_link");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public void click_add_to_cart_button_of_item(String item){
        switch (item) {
            case "Sauce Labs Backpack":
                driver.findElement(addToCartSauceLabsBackpackButton).click();
                break;
            case "Sauce Labs Bike Light":
                driver.findElement(addToCartSauceLabsBikeLightButton).click();
                break;
            case "Sauce Labs Bolt T-Shirt":
                driver.findElement(addToCartSauceLabsBoltTShirt).click();
                break;
            case "Sauce Labs Fleece Jacket":
                driver.findElement(addToCartSauceLabsFleeceJacket).click();
                break;
            case "Sauce Labs Onesie":
                driver.findElement(addToCartSauceLabsOnesie).click();
                break;
            case "Test.allTheThings() T-Shirt (Red)":
                driver.findElement(addToCartSauceLabsRedTShirt).click();
                break;
        }
    }

    public void click_add_to_cart_for_all_items(){
            driver.findElement(addToCartSauceLabsBackpackButton).click();
            driver.findElement(addToCartSauceLabsBikeLightButton).click();
            driver.findElement(addToCartSauceLabsBoltTShirt).click();
            driver.findElement(addToCartSauceLabsFleeceJacket).click();
            driver.findElement(addToCartSauceLabsOnesie).click();
            driver.findElement(addToCartSauceLabsRedTShirt).click();
    }

    public void click_remove_button_of_item(String item){
        switch (item) {
            case "Sauce Labs Backpack":
                driver.findElement(removeSauceLabsBackpackButton).click();
                break;
            case "Sauce Labs Bike Light":
                driver.findElement(removeSauceLabsBikeLightButton).click();
                break;
            case "Sauce Labs Bolt T-Shirt":
                driver.findElement(removeSauceLabsBoltTShirt).click();
                break;
            case "Sauce Labs Fleece Jacket":
                driver.findElement(removeSauceLabsFleeceJacket).click();
                break;
            case "Sauce Labs Onesie":
                driver.findElement(removeSauceLabsOnesie).click();
                break;
            case "Test.allTheThings() T-Shirt (Red)":
                driver.findElement(removeSauceLabsRedTShirt).click();
                break;
        }
    }

    public boolean is_button_changed_to_remove(String item) {
        return switch (item) {
            case "Sauce Labs Backpack" -> driver.findElement(removeSauceLabsBackpackButton).isDisplayed();
            case "Sauce Labs Bike Light" -> driver.findElement(removeSauceLabsBikeLightButton).isDisplayed();
            default -> false;
        };
    }

    public boolean is_all_button_changed_to_remove() {
        return driver.findElement(removeSauceLabsBackpackButton).isDisplayed() &&
                driver.findElement(removeSauceLabsBikeLightButton).isDisplayed() &&
                driver.findElement(removeSauceLabsBoltTShirt).isDisplayed() &&
                driver.findElement(removeSauceLabsFleeceJacket).isDisplayed() &&
                driver.findElement(removeSauceLabsOnesie).isDisplayed() &&
                driver.findElement(removeSauceLabsRedTShirt).isDisplayed();
    }

    public Integer cartNumberCount(){
        WebElement shoppingCartBadge = driver.findElement(cartNumber);
        return Integer.parseInt(shoppingCartBadge.getText());
    }

    public void select_product(){
        driver.findElement(productName).click();
    }

    public boolean is_number_visible(){
        try {
            return driver.findElement(cartNumber).isDisplayed();
        }
        catch (Exception e){
            return false;
        }
    }
}
