package com.gig.atfdemo.cars.adapters.message;

import com.gig.atfdemo.cars.application.port.out.ReceiveMessagePort;
import com.gig.atfdemo.cars.domain.Car;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@Component
public class KafkaRecieverPort implements ReceiveMessagePort {

    private List<Car> cars = new ArrayList<>();
    private final CountDownLatch latch = new CountDownLatch(1);
    private boolean reset;

    @KafkaListener(topics = "cars", groupId="cars-msg", containerFactory = "carKafkaListenerContainerFactory")
    public void consume(Car car) {
        if (reset) {
            cars = new ArrayList<>();
            reset = false;
        }
        cars.add(car);
    }

    @Override
    public List<Car> receive() {
        try {
            if (!latch.await(3000, TimeUnit.MILLISECONDS)) {
                reset = true;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return cars;
    }
}
