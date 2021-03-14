package com.Tests;

import com.Pojo.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static com.Utils.Constants.*;

import static io.restassured.RestAssured.given;

public class UserController {
    private RequestSpecification reqSpecification;
    private ResponseSpecification responseSpecification;

    public UserController (){
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri(user_endpoint);
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.log(LogDetail.ALL);
        reqSpecification = requestSpecBuilder.build();

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
        responseSpecBuilder.expectContentType(ContentType.JSON);
        responseSpecBuilder.log(LogDetail.ALL);
        responseSpecification = responseSpecBuilder.build();
    }

    public Response getUser(int id){
        return given(reqSpecification).
                pathParam("id", id).
                get("/{id}").
                then().spec(responseSpecification).extract().response();
    }

    public ListOfUsers getListOfUsers(){
        return given(reqSpecification).
                get().as(ListOfUsers.class);
    }

    public NewUserResponse createUser(NewUser user){
        return given(reqSpecification).
                body(user).
                post().then().spec(responseSpecification).extract().as(NewUserResponse.class);
    }

    public void updateUser(int id, UpdatedUser updatedUser){
        given(reqSpecification).
                pathParam("id", id).
                body(updatedUser).
                put("/{id}");
    }

    public Response deleteUser(int id) {
        return given(reqSpecification).pathParam("id", id).
                delete("/{id}").then().extract().response();
    }
}
