package com.Tests;

import com.Pojo.*;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static com.Utils.DataGenerator.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class UserTests {
    UserController userController;

    SingleUser singleUser = new SingleUser.Builder()
            .withID(1)
            .withFirstName(getUserFirstName())
            .withLasName(getUserLastName())
            .withEmail(getUserEmail())
            .withAvatar(getAvatar())
            .withUrl(getUrl())
            .withText(getText())
            .build();
    NewUser newUser = new NewUser.Builder()
            .withName(getUserFirstName())
            .withJob(getUserJob())
            .build();
    UpdatedUser updatedUser = new UpdatedUser.Builder()
            .withName(getUserFirstName())
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
        Response response = userController.getListOfUsers();
        assertThat(response.statusCode(), is(200));
        ListOfUsers listOfUsers = response.as(ListOfUsers.class);
        assertThat(listOfUsers.getData().size(), equalTo(6));
    }

    @Test (priority = 3)
    public void createUser(){
        Response response = userController.createUser(newUser);
        assertThat(response.getStatusCode(), is(201));
        NewUserResponse newUserResponse = response.as(NewUserResponse.class);
        assertThat(newUserResponse.getName(), equalTo(newUser.getName()));
        assertThat(newUserResponse.getJob(), equalTo(newUser.getJob()));
        assertThat(newUserResponse.getId(), is(not(emptyString())));
    }

    @Test (priority = 4)
    public void updateUser(){
        Response response = userController.updateUser(1, updatedUser);
        assertThat(response.statusCode(), is(200));
        UpdatedUserResponse updUserResponse = response.as(UpdatedUserResponse.class);
        assertThat(updUserResponse.getName(), equalTo(updatedUser.getName()));
        assertThat(updUserResponse.getJob(), equalTo(updatedUser.getJob()));
        assertThat(updUserResponse.getUpdatedAt(), is(not(emptyString())));
    }

    @Test (enabled = true)
    public void deleteUser(){
        Response response = userController.deleteUser(2);
        assertThat(response.getStatusCode(), is(204));
    }
}
