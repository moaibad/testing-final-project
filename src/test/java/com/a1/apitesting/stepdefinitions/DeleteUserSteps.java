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

public class DeleteUserSteps {
    private RequestSpecification httpRequest;
    private Response response;

    @Given("Pengguna sudah menentukan base url untuk delete user")
    public void user_set_base_url(){
        RestAssured.baseURI = "https://dummyapi.io/data/v1/";
    }

    @And("Pengguna tidak memiliki app-id untuk delete user")
    public void user_have_no_app_id(){
        httpRequest = RestAssured.given().header("app-id", "").contentType(ContentType.JSON);
    }

    @And("Pengguna memiliki app-id yang invalid untuk delete user")
    public void user_have_invalid_app_id(){
        httpRequest = RestAssured.given().header("app-id", "token0412").contentType(ContentType.JSON);
    }

    @And("Pengguna memiliki app-id yang valid untuk delete user")
    public void user_have_valid_app_id(){
        httpRequest = RestAssured.given().header("app-id", "663783f02e77a585c142311d").contentType(ContentType.JSON);
    }

    @When("Pengguna mengirim delete request dengan user id {string}")
    public void user_send_get_request(String userId){
        response = httpRequest.request(Method.DELETE, "/user/" + userId);
    }

    @Then("Pengguna menerima pesan error {string} dengan status code {string} ketika delete user")
    public void user_receive_error_message_and_status_code(String errorMessage, String statusCode){
        assertEquals("Unexpected status code", Integer.parseInt(statusCode), response.getStatusCode());
        assertTrue("Unexpected error message", response.getBody().asString().contains(errorMessage));
    }
    
    @Then("Pengguna menerima id user yang di hapus dengan status code {string}")
    public void user_receive_user_information_by_id_and_status_code(String statusCode){
        System.out.println(response.getBody().asString());
        assertEquals("Unexpected status code", Integer.parseInt(statusCode), response.getStatusCode());
    }

}
