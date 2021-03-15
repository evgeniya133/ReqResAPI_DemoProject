package com.Tests;

import com.Pojo.*;
import static com.Utils.SpecBuilder.*;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class UserController {

    public Response getUser(int id){
        return given(requestSpecification()).
                pathParam("id", id).
                get("/{id}").
                then().spec(responseSpecification()).extract().response();
    }

    public Response getListOfUsers(){
        return given(requestSpecification()).
                get().then().spec(responseSpecification()).extract().response();
    }

    public Response createUser(NewUser user){
        return given(requestSpecification()).
                body(user).
                post().then().spec(responseSpecification()).extract().response();
    }

    public Response updateUser(int id, UpdatedUser updatedUser){
       return given(requestSpecification()).
                pathParam("id", id).
                body(updatedUser).
                put("/{id}").then().spec(responseSpecification()).extract().response();
    }

    public Response deleteUser(int id) {
        return given(requestSpecification()).pathParam("id", id).
                delete("/{id}").then().spec(responseSpecification()).extract().response();
    }
}
