package com.gig.atfdemo.user.adapters.api;

import com.gig.atfdemo.user.application.port.out.GetUserListApiPort;
import com.gig.atfdemo.user.application.port.out.RegisterUserApiPort;
import com.gig.atfdemo.user.domain.User;
import io.cucumber.spring.ScenarioScope;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.gig.atfdemo.user.application.port.in.GetUserListUseCase.*;
import static com.gig.atfdemo.user.application.port.in.RegisterUserUseCase.*;
import static io.restassured.RestAssured.*;
import static io.restassured.http.ContentType.JSON;

@Log
@Component
@ScenarioScope
public class RestAssuredAdapter implements RegisterUserApiPort, GetUserListApiPort {

    private final String BASE_URI = "https://reqres.in";
    private final String BASE_PATH = "/api";

    @Override
    public RegisterUserResponse register(String email, String password) {
        Map<String, Object>  jsonAsMap = new HashMap<>();
        jsonAsMap.put("email", email);
        jsonAsMap.put("password", password);

        Response response = baseRequest()
                .accept(JSON)
                .contentType(JSON)
                .body(jsonAsMap)
                .when()
                .post("/register");
        JsonPath json = response.getBody().jsonPath();

        return new RegisterUserResponse(response.statusCode(), json.getString("token"),
                json.getString("error"));
    }

    @Override
    public GetUserListResponse listUsers(int page) {

        Response response = baseRequest()
                .accept(JSON).queryParam("page", page).get("/users");

        List<User> usersList = response.jsonPath().getList("data");

        return new GetUserListResponse(response.statusCode(), usersList);
    }

    private RequestSpecification baseRequest() {
        return given().baseUri(BASE_URI).basePath(BASE_PATH);
        //.log().all();
    }
}
