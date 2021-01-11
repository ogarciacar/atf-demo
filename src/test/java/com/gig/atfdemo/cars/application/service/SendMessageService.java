package com.gig.atfdemo.cars.application.service;

import com.gig.atfdemo.cars.application.port.in.SendMessageUseCase;
import com.gig.atfdemo.cars.application.port.out.SendMessagePort;
import com.gig.atfdemo.cars.domain.Car;
import io.cucumber.spring.ScenarioScope;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.stream.IntStream;

import static java.lang.String.*;

@Component
@ScenarioScope
@RequiredArgsConstructor
public class SendMessageService implements SendMessageUseCase {

    private final SendMessagePort sendMessagePort;

    @Override
    public void sendMessages(int amount) {

        IntStream.range(0, amount).forEach(i -> sendMessagePort.send(
                new Car(format("brand-%d", i), format("model-%d", i),
                        new Random().nextInt(7)+1,
                        new Random().nextBoolean())
        ));
    }
}
