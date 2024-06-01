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

    @And("Pengguna memiliki app-id yang invalid")
    public void user_have_invalid_app_id(){
        httpRequest = RestAssured.given().header("app-id", "token0412").contentType(ContentType.JSON);
    }

    @And("Pengguna memiliki app-id yang valid")
    public void user_have_valid_app_id(){
        httpRequest = RestAssured.given().header("app-id", "663783f02e77a585c142311d").contentType(ContentType.JSON);
    }

    @When("Pengguna mengirim get request")
    public void user_send_get_request(){
        response = httpRequest.request(Method.GET, "/user/");
    }

    @When("Pengguna mengirim get request dengan id {string}")
    public void user_send_get_request_by_id(String userId){
        response = httpRequest.request(Method.GET, "/user/" + userId);
    }

    @Then("Pengguna menerima pesan error {string} dengan status code {string}")
    public void user_receive_error_message_and_status_code(String errorMessage, String statusCode){
        assertEquals("Unexpected status code", Integer.parseInt(statusCode), response.getStatusCode());
        assertTrue("Unexpected error message", response.getBody().asString().contains(errorMessage));
    }

    @Then("Pengguna menerima user information dengan status code {string}")
    public void user_receive_user_information_and_status_code(String statusCode){
        String expectedResponseBody = "{\"data\":["
                + "{"
                + "\"id\":\"60d0fe4f5311236168a109ca\","
                + "\"title\":\"ms\","
                + "\"firstName\":\"Sara\","
                + "\"lastName\":\"Andersen\","
                + "\"picture\":\"https://randomuser.me/api/portraits/women/58.jpg\""
                + "},";
        assertEquals("Unexpected status code", Integer.parseInt(statusCode), response.getStatusCode());
        assertTrue("Failed to retrieve users information", response.getBody().asString().contains(expectedResponseBody));
    }

    @Then("Pengguna menerima user information berdasarkan id dengan status code {string}")
    public void user_receive_user_information_by_id_and_status_code(String statusCode){
        String expectedResponseBody = "{"
                + "\"id\":\"60d0fe4f5311236168a109cc\","
                + "\"title\":\"ms\","
                + "\"firstName\":\"Adina\","
                + "\"lastName\":\"Barbosa\","
                + "\"picture\":\"https://randomuser.me/api/portraits/med/women/28.jpg\","
                + "\"gender\":\"female\","
                + "\"email\":\"edina.barbosa@example.com\","
                + "\"dateOfBirth\":\"1952-09-03T13:27:29.424Z\","
                + "\"phone\":\"(64) 5796-9260\","
                + "\"location\":{"
                + "\"street\":\"8750, Rua Carlos Gomes\","
                + "\"city\":\"Recife\","
                + "\"state\":\"CearÃ¡\","
                + "\"country\":\"Brazil\","
                + "\"timezone\":\"+1:00\""
                + "},"
                + "\"registerDate\":\"2021-06-21T21:02:07.719Z\","
                + "\"updatedDate\":\"2021-06-21T21:02:07.719Z\""
                + "}";

        assertEquals("Unexpected status code", Integer.parseInt(statusCode), response.getStatusCode());
        assertTrue("Failed to retrieve users information", response.getBody().asString().contains(expectedResponseBody));
    }

}
