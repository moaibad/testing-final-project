package com.a1.apitesting.stepdefinitions;

import com.a1.apitesting.utils.FileUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class UpdateUserSteps {
    private RequestSpecification httpRequest;
    private Response response;

    @Given("Pengguna sudah menentukan base url untuk update user")
    public void user_set_base_url(){
        RestAssured.baseURI = "https://dummyapi.io/data/v1/";
        httpRequest = given();
    }

    @And("Pengguna memiliki app-id yang valid untuk update user")
    public void user_have_valid_app_id(){
        httpRequest = given().header("app-id", "663783f02e77a585c142311d").contentType(ContentType.JSON);
    }

    @When("Pengguna mengirim update request dengan request body {string} dan id user {string}")
    public void user_send_get_request(String path, String userId){
        String requestBody = "";
        try {
            requestBody = FileUtils.readFileAsString("src/test/resources/apitesting/update/" + path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        response = httpRequest
                .contentType(ContentType.JSON)
                .body(requestBody)
                .put("/user/" + userId);
    }

    @Then("Pengguna menerima data user yang telah diubah dengan status code {string} ketika update user")
    public void user_receive_created_user_body_and_status_code(String statusCode){
        System.out.println(response.getBody().asString());
        assertEquals("Unexpected status code", Integer.parseInt(statusCode), response.getStatusCode());
    }
}
