package com.gig.atfdemo.cars.application.service;

import com.gig.atfdemo.cars.application.port.in.SendMessageUseCase;
import com.gig.atfdemo.cars.application.port.out.SendMessagePort;
import com.gig.atfdemo.cars.domain.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.String.*;

@Component
@RequiredArgsConstructor
public class SendMessageService implements SendMessageUseCase {

    private final SendMessagePort sendMessagePort;

    @Override
    public List<Car> sendMessages(int amount) {

        return IntStream.range(0, amount)
                .mapToObj(i -> new Car(format("brand-%d", i), format("model-%d", i),
                new Random().nextInt(4)+1, new Random().nextBoolean())
                ).peek(sendMessagePort::send).collect(Collectors.toList());
    }
}
