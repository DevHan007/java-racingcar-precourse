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

    public Map<String, Integer> getTrackRecordSum(Map<String, List<Integer>> trackRecords, int lap) {
        Map<String, Integer> recordSum = new HashMap<>();
        for (String mapKey : trackRecords.keySet()) {
            recordSum.put(mapKey, getRecordSum(trackRecords.get(mapKey), lap));
        }
        return recordSum;
    }

    private int getRecordSum(List<Integer> carPositions, int lap) {
        int positionSum = 0;
        for (int trackIndex = 0; trackIndex <= lap; trackIndex++) {
            positionSum = positionSum + carPositions.get(trackIndex);
        }
        return positionSum;
    }

}
