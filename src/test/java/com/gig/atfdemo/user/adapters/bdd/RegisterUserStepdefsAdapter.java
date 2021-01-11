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

    @Given("the user types email {string} and password {string}")
    public void the_user_types_email_and_password(String email, String password) {
        registerUserCommand = new RegisterUserCommand(email, password);
    }

    @When("the user tries to register into the system")
    public void the_user_tries_to_register_into_the_system() {
        registerUserResponse = registerUserUseCase.registerUser(registerUserCommand);
    }



    @Then("the system responds {string} and the error message is {string}")
    public void theSystemRespondsAndTheErrorMessageIs(String status, String error) {

        assertEquals(Integer.parseInt(status), registerUserResponse.getStatus());

        if (error != null && !"".equals(error.trim())) {
            assertNull(registerUserResponse.getToken());
            assertEquals(error, registerUserResponse.getError());
        } else {
            assertNotNull(registerUserResponse.getToken());
            assertNull(registerUserResponse.getError());
        }
    }
}
