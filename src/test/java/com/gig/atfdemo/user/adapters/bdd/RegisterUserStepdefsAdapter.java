package com.gig.atfdemo.user.adapters.bdd;

import com.gig.atfdemo.SpringIntegrationTests;
import com.gig.atfdemo.user.application.port.in.RegisterUserUseCase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import static org.junit.Assert.*;

import static com.gig.atfdemo.user.application.port.in.RegisterUserUseCase.*;
import static com.gig.atfdemo.user.application.port.in.RegisterUserUseCase.RegisterUserCommand;

@Log
@RequiredArgsConstructor
public class RegisterUserStepdefsAdapter extends SpringIntegrationTests {

    private final RegisterUserUseCase registerUserUseCase;
    private RegisterUserCommand registerUserCommand;
    private RegisterUserResponse registerUserResponse;

    @Given("the user types only its email {string}")
    public void the_user_types_only_its_email(String email) {
        registerUserCommand = new RegisterUserCommand(email, null);
    }

    @Then("the user gets an error {int} and the message {string}")
    public void the_user_gets_an_error_and_the_message(int statusCode, String errorMessage) {
        assertEquals(statusCode, registerUserResponse.getStatus());
        assertEquals(errorMessage, registerUserResponse.getError());
        assertNull(registerUserResponse.getToken());
    }

    @When("the user tries to register into the system")
    public void the_user_tries_to_register_into_the_system() {
        registerUserResponse = registerUserUseCase.registerUser(registerUserCommand);
    }

    @Given("the user types email {string} and password {string}")
    public void the_user_types_email_and_password(String email, String password) {
        registerUserCommand = new RegisterUserCommand(email, password);
    }

    @Then("the user gets a successful registration along with a token")
    public void the_user_gets_a_successful_registration_along_with_a_token() {
        assertEquals(200, registerUserResponse.getStatus());
        assertNotNull(registerUserResponse.getToken());
        assertNull(registerUserResponse.getError());
    }
}
