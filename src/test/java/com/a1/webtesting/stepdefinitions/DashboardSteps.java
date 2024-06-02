package com.a1.webtesting.stepdefinitions;

import com.a1.webtesting.pages.DashboardPage;
import com.a1.webtesting.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DashboardSteps {
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Given("Pengguna sudah berhasil login ke aplikasi")
    public void user_logged_in_succesfully(){
        Hooks.driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(Hooks.driver);
        dashboardPage = new DashboardPage(Hooks.driver);

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
    }

    @Given("Pengguna berada pada halaman dashboard")
    public void user_on_the_dashboard_page() {
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        assertEquals(expectedUrl, loginPage.getCurrentUrl());
    }

    @When("Pengguna menekan tombol Add to Cart pada barang {string}")
    public void user_add_item_to_cart(String item){
        dashboardPage.click_add_to_cart_button_of_item(item);
    }

    @When("Pengguna menekan tombol Add to Cart pada semua barang")
    public void user_add_all_items_to_cart(){
        dashboardPage.click_add_to_cart_for_all_items();
    }

    @When("Pengguna menekan tombol Remove pada barang {string}")
    public void user_remove_item_from_cart(String item){
        dashboardPage.click_remove_button_of_item(item);
    }

    @And("Tombol Add to Cart pada produk {string} berubah menjadi tombol Remove")
    public void add_to_cart_button_of_item_changes_to_remove(String item){
        assertTrue("Add to Cart button not changed", dashboardPage.is_button_changed_to_remove(item));
    }

    @And("Tombol Add to Cart pada semua barang berubah menjadi tombol Remove")
    public void add_to_cart_button_of_all_items_changes_to_remove(){
        assertTrue("Add to Cart button not changed", dashboardPage.is_all_button_changed_to_remove());
    }

    @Then("Sistem menampilkan nilai pada logo cart sebesar {string}")
    public void number_of_item_in_cart(String number){
        Integer expectedNumber = Integer.parseInt(number);
        assertEquals("Unexpected cart number", expectedNumber, dashboardPage.cartNumberCount());
    }
}
