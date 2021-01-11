package com.gig.atfdemo.cars.adapters.bdd;

import com.gig.atfdemo.SpringIntegrationTests;
import com.gig.atfdemo.cars.application.port.in.SendMessageUseCase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SendAndReceiveCarMessagesStepdefsAdapter extends SpringIntegrationTests {

    private final SendMessageUseCase sendMessageUseCase;

    @Given("the pipeline is up and running")
    public void the_pipeline_is_up_and_running() {
    }
    @When("the producer sends {int} cars")
    public void the_producer_sends_cars(int amount) {
        sendMessageUseCase.sendMessages(amount);
    }
    @Then("the consumer receives {int} cars")
    public void the_consumer_receives_cars(Integer int1) {
    }

}
