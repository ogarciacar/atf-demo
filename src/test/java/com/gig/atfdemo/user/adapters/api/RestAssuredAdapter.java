package com.gig.atfdemo.user.adapters.api;

import com.gig.atfdemo.user.application.port.out.RegisterUserApiPort;
import io.cucumber.spring.ScenarioScope;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.gig.atfdemo.user.application.port.in.RegisterUserUseCase.*;
import static io.restassured.RestAssured.*;
import static io.restassured.http.ContentType.JSON;

@Log
@Component
@ScenarioScope
public class RestAssuredAdapter implements RegisterUserApiPort {

    private static final String ENDPOINT_REGISTER_USER = "https://reqres.in/api/register";

    @Override
    public RegisterUserResponse register(String email, String password) {
        Map<String, Object>  jsonAsMap = new HashMap<>();
        jsonAsMap.put("email", email);
        jsonAsMap.put("password", password);

        Response response = given()
                .contentType(JSON)
                .body(jsonAsMap)
                .when()
                .post(ENDPOINT_REGISTER_USER);
        JsonPath json = response.getBody().jsonPath();

        return new RegisterUserResponse(response.statusCode(), json.getString("token"),
                json.getString("error"));
    }
}
