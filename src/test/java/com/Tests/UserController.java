package com.Tests;

import com.Pojo.ListOfUsers;
import com.Pojo.NewUser;
import com.Pojo.SingleUser;
import com.Pojo.UpdatedUser;
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
        RequestSpecBuilder resSpecBuilder = new RequestSpecBuilder();
        resSpecBuilder.setBaseUri(user_endpoint);
        resSpecBuilder.setContentType(ContentType.JSON);
        resSpecBuilder.log(LogDetail.ALL);
        reqSpecification = resSpecBuilder.build();

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
        responseSpecBuilder.expectContentType(ContentType.JSON);
        responseSpecification = responseSpecBuilder.build();
    }

    public Response getSingleUser(int id){
        return given(reqSpecification).
                pathParam("id", id).
                get("/{id}").
                then().log().body().extract().response();
    }

    public ListOfUsers getListOfUsers(){
        return given(reqSpecification).
                get().as(ListOfUsers.class);
    }

    public JsonPath createUser(NewUser user){
        return given(reqSpecification).
                body(user).
                post().then().log().body().extract().jsonPath();
    }

    public void updateUser(int id, UpdatedUser updatedUser){
        given(reqSpecification).
                pathParam("id", id).
                body(updatedUser).
                put("/{id}");
    }

    public void deleteUser(int id) {
        given(reqSpecification).pathParam("id", id).
                delete("/{id}");
    }


}
