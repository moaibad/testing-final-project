package com.a1.webtesting.stepdefinitions;

import com.a1.webtesting.pages.CartPage;
import com.a1.webtesting.pages.CheckoutPage;
import com.a1.webtesting.pages.DashboardPage;
import com.a1.webtesting.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CheckoutSteps {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    @Given("Pengguna berhasil melakukan login")
    public void user_logged_in_succesfully(){
        Hooks.driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(Hooks.driver);
        dashboardPage = new DashboardPage(Hooks.driver);
        cartPage = new CartPage(Hooks.driver);
        checkoutPage = new CheckoutPage(Hooks.driver);

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
    }

    @And("Pengguna berada di halaman dashboard")
    public void user_is_on_the_dashboard_page(){
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        assertEquals(expectedUrl, loginPage.getCurrentUrl());
    }

    @And("Pengguna menambah barang {string} ke dalam cart")
    public void user_add_item_to_cart(String item){
        dashboardPage.click_add_to_cart_button_of_item(item);
    }

    @And("Pengguna menekan cart")
    public void user_click_cart_icon(){
        dashboardPage.click_cart_icon();
    }

    @And("Pengguna diarahkan ke halaman cart")
    public void user_is_on_cart_page(){
        String expectedUrl = "https://www.saucedemo.com/cart.html";
        assertEquals(expectedUrl, loginPage.getCurrentUrl());
    }

    @And("Pengguna memilih opsi Checkout")
    public void user_click_checkout_button(){
        cartPage.click_checkout_button();
    }

    @And("Pengguna dialihkan ke halaman checkout information")
    public void user_redirected_to_checkout_information_page(){
        String expectedUrl = "https://www.saucedemo.com/checkout-step-one.html";
        assertTrue("User is not on checkout information", loginPage.getCurrentUrl().contains(expectedUrl));
    }

    @When("Pengguna mengisikan field first name dengan value {string}")
    public void user_input_first_name(String input){
        checkoutPage.enter_first_name(input);
    }

    @And("Pengguna mengisikan field last name dengan value {string}")
    public void user_input_last_name(String input){
        checkoutPage.enter_last_name(input);
    }

    @And("Pengguna mengisikan field postal code dengan value {string}")
    public void user_input_postal_code(String input){
        checkoutPage.enter_postal_code(input);
    }

    @And("Pengguna menekan tombol continue")
    public void user_click_continue_button(){
        checkoutPage.click_continue_button();
    }

    @And("Pengguna menekan tombol cancel")
    public void user_click_cancel_button(){
        checkoutPage.click_cancel_button();
    }

    @And("Pengguna menekan tombol finish")
    public void user_click_finish_button(){
        checkoutPage.click_finish_button();
    }

    @Then("Pengguna dialihkan ke halaman checkout overview")
    public void user_is_redirected_to_checkout_overview_page(){
        String expectedUrl = "https://www.saucedemo.com/checkout-step-two.html";
        assertTrue("User is not on checkout overview", loginPage.getCurrentUrl().contains(expectedUrl));
    }

    @Then("Sistem menampilkan checkout complete")
    public void system_show_checkout_complete(){
        String expectedUrl = "https://www.saucedemo.com/checkout-complete.html";
        assertTrue("Checkout failed", loginPage.getCurrentUrl().contains(expectedUrl));
    }


}
