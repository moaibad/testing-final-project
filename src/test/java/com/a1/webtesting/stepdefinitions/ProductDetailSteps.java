package com.a1.webtesting.stepdefinitions;

import com.a1.webtesting.pages.DashboardPage;
import com.a1.webtesting.pages.LoginPage;
import com.a1.webtesting.pages.ProductDetailPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class ProductDetailSteps {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    ProductDetailPage productDetailPage;

    @Given("Pengguna sudah login ke dalam aplikasi")
    public void user_logged_in_succesfully(){
        Hooks.driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(Hooks.driver);
        dashboardPage = new DashboardPage(Hooks.driver);
        productDetailPage = new ProductDetailPage((Hooks.driver));

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
    }

    @And("Pengguna sudah memilih barang yang ingin dilihat detailnya")
    public void user_selected_product(){
        dashboardPage.select_product();
    }

    @And("Pengguna berada pada halaman detail produk")
    public void user_on_the_product_detail_product(){
        String expectedUrl = "https://www.saucedemo.com/inventory-item.html";
        assertTrue("User is not on product detail page", loginPage.getCurrentUrl().contains(expectedUrl));
    }

    @Then("Aplikasi menampilkan nama produk")
    public void system_show_product_name(){
        assertTrue("Product name isn't visible", productDetailPage.is_product_name_visible());
    }

    @And("Aplikasi menampilkan deskripsi produk")
    public void system_show_product_description(){
        assertTrue("Product description isn't visible", productDetailPage.is_product_description_visible());
    }

    @And("Aplikasi menampilkan harga produk")
    public void system_show_product_price(){
        assertTrue("Product price isn't visible", productDetailPage.is_product_price_visible());
    }

    @And("Aplikasi menampilkan gambar produk")
    public void system_show_product_image(){
        assertTrue("Product image isn't visible", productDetailPage.is_product_image_visible());
    }

    @When("Pengguna menekan tombol Add to Cart")
    public void user_click_add_to_cart_button(){
        productDetailPage.click_add_to_cart_button();
    }

    @And("Pengguna menekan tombol Remove")
    public void user_click_remove_button(){
        productDetailPage.click_remove_button();
    }

    @Then("Tombol Add to Cart pada barang berubah menjadi tombol Remove")
    public void add_to_cart_button_changed_to_remove(){
        assertTrue("Add to Cart button not changed", productDetailPage.is_add_to_cart_button_changed_to_remove());
    }

    @Then("Tombol Remove pada barang berubah menjadi tombol Add to Cart")
    public void remove_button_changed_to_add_to_cart(){
        assertTrue("Remove button not changed", productDetailPage.is_remove_button_changed_to_add_to_cart());
    }

    @And("Sistem menampilkan angka pada logo cart")
    public void system_show_number_on_cart_logo(){
        assertTrue("Product count isn't visible", dashboardPage.is_number_visible());
    }

    @And("Sistem menyembunyikan angka pada logo cart")
    public void system_hide_number_on_cart_logo(){
        assertFalse("Product count is still visible", dashboardPage.is_number_visible());
    }
}
