package com.racing.service;

import com.racing.car.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingService {
    private static final int DECISION_MOVING_NUMBER = 3;

    public List<String> divideCarNames(String inputCarNames) {
        return Arrays.asList(inputCarNames.split(","));
    }

    public List<Car> createRacingGameCars(List<String> inputCarNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : inputCarNames) {
            Car car = new Car(carName, MovingType.STOP.getMovingValue());
            cars.add(car);
        }
        return cars;
    }

    public MovingType movingTypeCheck(int inputMovingNumber) {
        if (checkGoMoving(inputMovingNumber)) {
            return MovingType.GO;
        }
        return MovingType.STOP;
    }

    private boolean checkGoMoving(int inputMovingNumber) {
        return inputMovingNumber > DECISION_MOVING_NUMBER;
    }

    public List<Car> playGame(List<Car> cars, List<String> divideCarNames, int gameLap) {
        for (int lap = 0; lap < gameLap; lap++) {
            cars = oneTurnRacingGame(cars, divideCarNames);
        }
        return cars;
    }

    private List<Car> oneTurnRacingGame(List<Car> cars, List<String> divideCarNames) {
        for (String carName : divideCarNames) {
            cars.add(new Car(carName, movingTypeCheck(getRandomNumber()).getMovingValue()));
        }
        return cars;
    }

    public int getRandomNumber() {
        return (int) (Math.random() * 9);
    }
}
