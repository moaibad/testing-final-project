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

public class EndToEndSteps {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    @Given("Pengguna berada pada halaman login")
    public void user_is_on_the_login_page(){
        Hooks.driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(Hooks.driver);
        dashboardPage = new DashboardPage(Hooks.driver);
        cartPage = new CartPage(Hooks.driver);
        checkoutPage = new CheckoutPage(Hooks.driver);
    }

    @When("Pengguna mengisikan username {string}")
    public void user_enter_username(String username){
        loginPage.enterUsername(username);
    }

    @And("Pengguna mengisikan password {string}")
    public void user_enter_password(String password){
        loginPage.enterPassword(password);
    }

    @And("Pengguna menekan login")
    public void user_click_login_button(){
        loginPage.clickLoginButton();
    }

    @And("Pengguna menekan Add to Cart pada barang {string}")
    public void user_add_item_to_cart(String item){
        dashboardPage.click_add_to_cart_button_of_item(item);
    }

    @And("Pengguna menekan logo cart")
    public void user_click_cart_icon(){
        dashboardPage.click_cart_icon();
    }

    @And("Pengguna menekan tombol checkout")
    public void user_click_checkout_button(){
        cartPage.click_checkout_button();
    }

    @And("Pengguna mengisikan field first name dengan {string}")
    public void user_enter_first_name(String firstName){
        checkoutPage.enter_first_name(firstName);
    }
    @And("Pengguna mengisikan field last name dengan {string}")
    public void user_enter_last_name(String lastName){
        checkoutPage.enter_last_name(lastName);
    }

    @And("Pengguna mengisikan field postal code dengan {string}")
    public void user_enter_postal_code(String postalCode){
        checkoutPage.enter_postal_code(postalCode);
    }

    @And("Pengguna menekan continue")
    public void user_click_continue_button(){
        checkoutPage.click_continue_button();
    }

    @And("Pengguna menekan finish")
    public void user_click_finish_button(){
        checkoutPage.click_finish_button();
    }

    @Then("Aplikasi menampilkan pembelian berhasil")
    public void system_show_checkout_complete(){
        String expectedUrl = "https://www.saucedemo.com/checkout-complete.html";
        assertTrue("Checkout failed", loginPage.getCurrentUrl().contains(expectedUrl));
    }

}
