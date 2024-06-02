package com.a1.webtesting.stepdefinitions;

import com.a1.webtesting.pages.LoginPage;
import com.a1.webtesting.pages.MenuPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class MenuSteps {
    LoginPage loginPage;
    MenuPage menuPage;

    @Given("Pengguna telah login ke aplikasi")
    public void user_logged_in_succesfully(){
        Hooks.driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(Hooks.driver);
        menuPage = new MenuPage(Hooks.driver);

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
    }

    @Given("Pengguna telah berada pada halaman dashboard")
    public void user_on_the_dashboard_page() {
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        assertEquals(expectedUrl, loginPage.getCurrentUrl());
    }

    @When("Pengguna menekan tombol menu")
    public void user_click_menu_button(){
        menuPage.click_menu_button();
    }

    @And("Pengguna menekan tombol About")
    public void user_click_about_button(){
        menuPage.click_about_button();
    }

    @And("Pengguna menekan tombol close")
    public void user_click_close_button(){
        menuPage.click_close_button();
    }

    @Then("Sistem menampilkan opsi berikut:")
    public void system_show_options(DataTable data){
        assertTrue("Menu is not showing the right options", menuPage.show_options(data));
    }

    @Then("Sistem menampilkan halaman About")
    public void user_on_the_about_page(){
        String expectedUrl = "https://saucelabs.com/";
        assertEquals(expectedUrl, loginPage.getCurrentUrl());
    }

    @Then("Sistem menyembunyikan opsi berikut:")
    public void system_hide_options(DataTable data){
        assertFalse("Menu is still visible", menuPage.show_options(data));
    }
}
