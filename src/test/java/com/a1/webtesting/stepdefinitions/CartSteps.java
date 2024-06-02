package com.a1.webtesting.stepdefinitions;

import com.a1.webtesting.pages.CartPage;
import com.a1.webtesting.pages.DashboardPage;
import com.a1.webtesting.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CartSteps {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CartPage cartPage;

    @Given("Pengguna sudah melakukan login")
    public void user_logged_in_succesfully(){
        Hooks.driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(Hooks.driver);
        dashboardPage = new DashboardPage(Hooks.driver);
        cartPage = new CartPage(Hooks.driver);

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
    }

    @And("Pengguna sudah berada pada halaman dashboard")
    public void user_is_on_the_dashboard_page(){
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        assertTrue("User is not on dashboard page", loginPage.getCurrentUrl().contains(expectedUrl));
    }

    @When("Pengguna menambah barang {string} ke cart")
    public void user_add_item_to_cart(String item){
        dashboardPage.click_add_to_cart_button_of_item(item);
    }

    @And("Pengguna menekan icon cart")
    public void user_click_cart_button(){
        dashboardPage.click_cart_icon();
    }

    @Then("Pengguna berada pada halaman cart")
    public void user_is_on_the_cart_page(){
        String expectedUrl = "https://www.saucedemo.com/cart.html";
        assertTrue("User is not on dashboard page", loginPage.getCurrentUrl().contains(expectedUrl));
    }

    @And("Pengguna melihat {string} produk di dalam cart")
    public void user_see_the_number_of_product_in_the_cart(String number){
        Integer expectedNumber = Integer.parseInt(number);
        assertEquals("Unexpected number of product appear in cart", expectedNumber, cartPage.count_product_in_the_cart());
    }

    @And("Pengguna menekan tombol Continue Shopping")
    public void user_click_continue_shopping_button(){
        cartPage.click_continue_shopping_button();
    }

    @And("Pengguna menekan tombol Checkout")
    public void user_click_checkout_button(){
        cartPage.click_checkout_button();
    }

    @Then("Pengguna dialihkan ke halaman dashboard")
    public void user_redirected_to_dashboard_page(){
        user_is_on_the_dashboard_page();
    }

    @Then("Pengguna dialihkan ke halaman checkout")
    public void user_redirected_to_checkout_page(){
        String expectedUrl = "https://www.saucedemo.com/checkout-step-one.html";
        assertTrue("User is not on checkout page", loginPage.getCurrentUrl().contains(expectedUrl));
    }
}
