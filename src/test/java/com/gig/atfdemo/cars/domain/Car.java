package com.gig.atfdemo.cars.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class Car {
    String brandName;
    String model;
    Integer numberOfDoors;
    boolean isSportCar;

    public Car(String brandName, String model, Integer numberOfDoors, boolean isSportCar) {
        this.brandName = brandName;
        this.model = model;
        this.numberOfDoors = numberOfDoors;
        this.isSportCar = isSportCar;
    }
}
