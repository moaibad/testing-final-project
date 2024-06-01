package com.a1.apitesting.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import com.a1.apitesting.utils.FileUtils;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CreateUserSteps {

    private RequestSpecification httpRequest;
    private Response response;

    @Given("Pengguna sudah menentukan base url untuk create user")
    public void user_set_base_url(){
        RestAssured.baseURI = "https://dummyapi.io/data/v1/";
        httpRequest = given();
    }

    @And("Pengguna tidak memiliki app-id untuk create user")
    public void user_have_no_app_id(){
        httpRequest = given().header("app-id", "").contentType(ContentType.JSON);
    }

    @And("Pengguna memiliki app-id yang invalid untuk create user")
    public void user_have_invalid_app_id(){
        httpRequest = given().header("app-id", "token0412").contentType(ContentType.JSON);
    }

    @And("Pengguna memiliki app-id yang valid untuk create user")
    public void user_have_valid_app_id(){
        httpRequest = given().header("app-id", "663783f02e77a585c142311d").contentType(ContentType.JSON);
    }

    @When("Pengguna mengirim create request dengan request body {string}")
    public void user_send_get_request(String path){
        String requestBody = "";
        try {
            requestBody = FileUtils.readFileAsString("src/test/resources/apitesting/create/" + path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        response = httpRequest
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post("/user/create/");
    }

    @Then("Pengguna menerima pesan error {string} dengan status code {string} ketika create user")
    public void user_receive_error_message_and_status_code(String errorMessage, String statusCode){
        assertEquals("Unexpected status code", Integer.parseInt(statusCode), response.getStatusCode());
        assertTrue("Unexpected error message", response.getBody().asString().contains(errorMessage));
    }

    @Then("Pengguna menerima data user yang telah dibuat dengan status code {string} ketika create user")
    public void user_receive_created_user_body_and_status_code(String statusCode){
        System.out.println(response.getBody().asString());
        assertEquals("Unexpected status code", Integer.parseInt(statusCode), response.getStatusCode());
    }

}
