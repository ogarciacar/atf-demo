package com.gig.atfdemo.cars.application.port.out;

import com.gig.atfdemo.cars.domain.Car;

public interface SendMessagePort {
    void send(Car car);
}
