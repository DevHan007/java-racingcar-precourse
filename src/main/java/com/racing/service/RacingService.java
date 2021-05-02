package com.racing.service;

import com.racing.car.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingService {

    public List<String> divideCarNames(String inputCarNames) {
        return Arrays.asList(inputCarNames.split(","));
    }

    public List<Car> createRacingGameCars(List<String> inputCarNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : inputCarNames) {
            Car car = new Car(carName, 0);
            cars.add(car);
        }
        return cars;
    }
}
