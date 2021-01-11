package com.gig.atfdemo.cars.application.service;

import com.gig.atfdemo.cars.application.port.in.ReceiveMessageUseCase;
import com.gig.atfdemo.cars.application.port.out.ReceiveMessagePort;
import com.gig.atfdemo.cars.domain.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ReceiveMessageService implements ReceiveMessageUseCase {

    private final ReceiveMessagePort receiveMessagePort;

    @Override
    public List<Car> receiveMessages() {
        return receiveMessagePort.receive();
    }
}
