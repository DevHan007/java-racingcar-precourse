package com.racing.car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingGame {

    private final List<Car> racingGameCars;

    public RacingGame(List<Car> racingGameCars) {
        this.racingGameCars = racingGameCars;
    }

    public List<Car> getRacingGameCars() {
        return this.racingGameCars;
    }

    public Map<String, List<Integer>> getTrackRecord(List<String> divideCarNames) {
        Map<String, List<Integer>> trackRecords = new HashMap<>();
        for (String carName : divideCarNames) {
            List<Integer> carRecords = getTrackRecordByName(carName);
            trackRecords.put(carName, carRecords);
        }
        return trackRecords;
    }

    private List<Integer> getTrackRecordByName(String carName) {
        List<Integer> carRecords = new ArrayList<>();
        for (Car car : this.racingGameCars) {
            carRecords = checkCarRecords(carName, car, carRecords);
        }
        return carRecords;
    }

    private List<Integer> checkCarRecords(String carName, Car car, List<Integer> carRecords) {
        if (carName.equals(car.getCarName())) {
            carRecords.add(car.getPosition());
            return carRecords;
        }
        return carRecords;
    }

}
