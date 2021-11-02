package com.github.denakh.deckofcardsapi;

import com.github.denakh.deckofcardsapi.models.users.User;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.util.Map;

// See API description on https://testbase.atlassian.net/wiki/spaces/USERS/pages/592511089
public class UserRequester {

    private static final String USER_API_ROOT_URL = "http://users.bugred.ru/tasks/rest";
    private static final String CREATE_USER_WITH_TASKS_ENDPOINT = "/createuserwithtasks";
    private static final String ADD_AVATAR_ENDPOINT = "/addavatar/";
    private static final String DELETE_AVATAR_ENDPOINT = "/deleteavatar";

    private final RequestSpecification requestSpecification;

    public UserRequester() {
        requestSpecification =
                new RequestSpecBuilder()
                        .setBaseUri(USER_API_ROOT_URL)
                        .build();
    }

    public UserRequester(String userApiRootUrl) {
//        PreemptiveOAuth2HeaderScheme authenticationScheme = new PreemptiveOAuth2HeaderScheme();
//        authenticationScheme.setAccessToken(Constants.AUTH_TOKEN);
        PreemptiveBasicAuthScheme authenticationScheme = new PreemptiveBasicAuthScheme();
        authenticationScheme.setUserName(Constants.LOGIN);
        authenticationScheme.setPassword(Constants.PASSWORD);
        requestSpecification =
                new RequestSpecBuilder()
                        .setBaseUri(userApiRootUrl)
                        .setAuth(authenticationScheme)
                        .addHeader("SomeHeaderName", "someHeaderValue")
                        .build();
    }

    public User createUserWithTasks(User newUser) {
        Response response = RestAssured.given(requestSpecification)
                //.auth().preemptive().oauth2(Constants.AUTH_TOKEN)
                //.auth().preemptive().basic(Constants.LOGIN, Constants.PASSWORD)
                //.header("SomeHeaderName", "someHeaderValue")
                .contentType(ContentType.JSON)
                .body(newUser)
                .post(CREATE_USER_WITH_TASKS_ENDPOINT);
        System.out.println("Response body:");
        String bodyMessage = response.body().prettyPrint();
        assert response.statusCode() == 200;
        assert !bodyMessage.contains("error");
        return response.as(User.class);
    }

    public Map<String, String> addAvatar(File avatarFile, String email) {
        return RestAssured.given(requestSpecification)
                .param("email", email)
                .multiPart(avatarFile)
                .post(ADD_AVATAR_ENDPOINT)
                .then()
                .statusCode(200)
                .extract()
                .body().jsonPath().getMap("");
    }

    public Map<String, String> deleteAvatar(String email) {
        return RestAssured.given(requestSpecification)
                .param("email", email)
                .delete(DELETE_AVATAR_ENDPOINT)
                .then()
                .statusCode(200)
                .extract()
                .body().jsonPath().getMap("");
    }
}
