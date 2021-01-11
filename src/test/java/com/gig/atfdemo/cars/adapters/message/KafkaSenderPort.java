package com.gig.atfdemo.cars.adapters.message;

import com.gig.atfdemo.cars.application.port.out.SendMessagePort;
import com.gig.atfdemo.cars.domain.Car;
import io.cucumber.spring.ScenarioScope;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@ScenarioScope
@RequiredArgsConstructor
public class KafkaSenderPort implements SendMessagePort {

    @Value("${com.gig.atfdemo.kafka.topic}")
    private String topic;

    private final KafkaTemplate<String, Car> kafkaTemplate;

    @Override
    public void send(Car car) {
        kafkaTemplate.send(topic, car);
    }
}
