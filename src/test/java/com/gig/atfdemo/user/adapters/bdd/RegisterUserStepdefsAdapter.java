package com.gig.atfdemo.user.adapters.bdd;

import com.gig.atfdemo.SpringIntegrationTests;
import com.gig.atfdemo.user.application.port.in.RegisterUserUseCase;
import com.gig.atfdemo.user.application.service.RegisterUserService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static com.gig.atfdemo.user.application.port.in.RegisterUserUseCase.RegisterUserCommand;

@Log
@RequiredArgsConstructor
public class RegisterUserStepdefsAdapter extends SpringIntegrationTests {

    private final RegisterUserUseCase registerUserUseCase;
    private RegisterUserCommand registerUserCommand;

    @Given("the user types only its email {string}")
    public void the_user_types_only_its_email(String email) {
        registerUserCommand = new RegisterUserCommand(email, null);
    }

    @Then("the user gets an error {int} and the message {string}")
    public void the_user_gets_an_error_and_the_message(Integer int1, String string) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }

    @When("the user tries to register into the system")
    public void the_user_tries_to_register_into_the_system() {
        registerUserUseCase.registerUser(registerUserCommand);
    }

    @Given("the user types email {string} and password {string}")
    public void the_user_types_email_and_password(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }

    @Then("the user gets a successful registration along with a token")
    public void the_user_gets_a_successful_registration_along_with_a_token() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
}
