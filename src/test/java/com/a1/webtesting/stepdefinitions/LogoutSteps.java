package com.a1.webtesting.stepdefinitions;

import com.a1.webtesting.pages.LoginPage;
import com.a1.webtesting.pages.LogoutPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

public class LogoutSteps {
    LoginPage loginPage;
    LogoutPage logoutPage;

    @Given("Pengguna telah berhasil login ke aplikasi")
    public void user_logged_in_succesfully(){
        Hooks.driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(Hooks.driver);
        logoutPage = new LogoutPage(Hooks.driver);

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
    }

    @When("Pengguna membuka sidebar menu")
    public void user_open_sidebar_menu(){
        logoutPage.openSidebarMenu();
    }

    @And("Pengguna menekan tombol logout")
    public void user_click_logout_button(){
        logoutPage.clickLogoutButton();
    }

    @Then("Aplikasi menampilkan halaman login")
    public void user_on_login_page(){
        assertTrue(loginPage.isOnLoginPage());
    }
}
