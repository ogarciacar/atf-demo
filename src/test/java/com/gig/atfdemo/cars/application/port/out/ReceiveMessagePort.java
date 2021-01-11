package com.gig.atfdemo.cars.application.port.out;

import com.gig.atfdemo.cars.domain.Car;

import java.util.List;

public interface ReceiveMessagePort {
    List<Car> receive();
}
