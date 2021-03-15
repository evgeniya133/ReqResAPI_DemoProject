package com.Tests;

import com.Pojo.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static com.Utils.Constants.*;

import static io.restassured.RestAssured.given;

public class UserController {
    private RequestSpecification requestSpecification;
    private ResponseSpecification responseSpecification;

    public UserController (){
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri(user_endpoint);
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.log(LogDetail.ALL);
        requestSpecification = requestSpecBuilder.build();

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
        responseSpecBuilder.expectHeader("Server", "cloudflare");
        responseSpecBuilder.log(LogDetail.ALL);
        responseSpecification = responseSpecBuilder.build();
    }

    public Response getUser(int id){
        return given(requestSpecification).
                pathParam("id", id).
                get("/{id}").
                then().spec(responseSpecification).extract().response();
    }

    public Response getListOfUsers(){
        return given(requestSpecification).
                get().then().spec(responseSpecification).extract().response();
    }

    public Response createUser(NewUser user){
        return given(requestSpecification).
                body(user).
                post().then().spec(responseSpecification).extract().response();
    }

    public Response updateUser(int id, UpdatedUser updatedUser){
       return given(requestSpecification).
                pathParam("id", id).
                body(updatedUser).
                put("/{id}").then().spec(responseSpecification).extract().response();
    }

    public Response deleteUser(int id) {
        return given(requestSpecification).pathParam("id", id).
                delete("/{id}").then().spec(responseSpecification).extract().response();
    }
}
