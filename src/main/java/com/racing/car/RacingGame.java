package com.racing.car;

import java.util.List;

public class RacingGame {

    private final List<Car> racingGameCars;

    public RacingGame(List<Car> racingGameCars) {
        this.racingGameCars = racingGameCars;
    }

    public List<Car> getRacingGameCars() {
        return this.racingGameCars;
    }

}
