package com.a1.apitesting.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GetSteps {
    private RequestSpecification httpRequest;
    private Response response;

    @Given("Pengguna sudah menentukan base url")
    public void user_set_base_url(){
        RestAssured.baseURI = "https://dummyapi.io/data/v1/";
    }

    @And("Pengguna tidak memiliki app-id")
    public void user_have_no_app_id(){
        httpRequest = RestAssured.given().header("app-id", "").contentType(ContentType.JSON);
    }

    @When("Pengguna mengirim get request")
    public void user_send_get_request(){
        response = httpRequest.request(Method.GET, "/user/");
    }

    @Then("Pengguna menerima pesan error {string} dengan status code {string}")
    public void user_receive_error_message_and_status_code(String errorMessage, String statusCode){
        assertEquals("Unexpected status code", Integer.parseInt(statusCode), response.getStatusCode());
        assertTrue("Unexpected error message", response.getBody().asString().contains(errorMessage));
    }
}
