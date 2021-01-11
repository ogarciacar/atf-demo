package com.gig.atfdemo.cars.adapters.bdd;

import com.gig.atfdemo.SpringIntegrationTests;
import com.gig.atfdemo.cars.application.port.in.ReceiveMessageUseCase;
import com.gig.atfdemo.cars.application.port.in.SendMessageUseCase;
import com.gig.atfdemo.cars.domain.Car;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

@RequiredArgsConstructor
public class SendAndReceiveCarMessagesStepdefsAdapter extends SpringIntegrationTests {

    private final SendMessageUseCase sendMessageUseCase;
    private final ReceiveMessageUseCase receiveMessageUseCase;
    private List<Car> sentCars;

    @When("the producer sends {int} cars")
    public void the_producer_sends_cars(int numberOfMessages) {
        sentCars = sendMessageUseCase.sendMessages(numberOfMessages);
    }

    @Then("the consumer receives the same amount of cars")
    public void theConsumerReceivesTheSameAmountOfCars() {
        List<Car> deliveredCars = receiveMessageUseCase.receiveMessages();
        assertThat(deliveredCars).isEqualTo(sentCars);
    }
}
