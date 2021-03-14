package com.Tests;

import com.Pojo.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.Utils.UserGenerator.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class UserTests {
    UserController userController;
    SingleUser singleUser = new SingleUser.Builder()
            .withData(Data.data1)
            .withSupport(Support.support1)
            .build();
    NewUser newUser = new NewUser.Builder()
            .withName(getUserName())
            .withJob(getUserJob())
            .build();
    UpdatedUser updatedUser = new UpdatedUser.Builder()
            .withName(getUserName())
            .withJob(getUserJob())
            .build();

    @BeforeClass
    public void beforeClass(){
        userController = new UserController();
    }

    @Test(priority = 1)
    public void getUserValidID() {
        int expectedID = validUserID();
        Response response = userController.getUser(expectedID);
        assertThat(response.getStatusCode(), is(200));
        SingleUser su = response.getBody().as(SingleUser.class);
        assertThat(su.getData().getId(), is(equalTo(expectedID)));
    }

    @Test(priority = 1)
    public void getUserInvalidID() {
        int expectedID = invalidUserID();
        Response response = userController.getUser(expectedID);
        assertThat(response.getStatusCode(), is(404));
    }

    @Test (priority = 2)
    public void getListOfUsers(){
        ListOfUsers list = userController.getListOfUsers();
        assertThat(list.getPer_page(), is(6));
        assertThat(list.getPage(), is(1));
    }

    @Test (priority = 3)
    public void createUser(){
        JsonPath jp = userController.createUser(newUser);
        assertThat(jp.get("createdAt"), is(not(empty())));
    }

    @Test (priority = 4)
    public void updateUser(){
        userController.updateUser(1, updatedUser);
    }

    @Test (priority = 5)
    public void deleteUser(){
        Response response = userController.deleteUser(2);
        assertThat(response.getStatusCode(), is(204));
    }
}
