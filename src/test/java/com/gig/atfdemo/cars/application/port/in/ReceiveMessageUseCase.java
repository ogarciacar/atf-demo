package com.gig.atfdemo.cars.application.port.in;

import com.gig.atfdemo.cars.domain.Car;

import java.util.List;

public interface ReceiveMessageUseCase {
    List<Car> receiveMessages();
}
