package com.racing;

import com.racing.car.Car;
import com.racing.car.RacingGame;
import com.racing.service.RacingService;
import com.racing.ui.GameResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingGameApp {
    private RacingService racingService;
    private GameResult gameResult;
    private RacingGame racingGame;
    private List<String> inputCarNames;
    private int inputGameLap;


    public RacingGameApp(String inputCarNames, int inputGameLap) {
        this.racingService = new RacingService();
        this.gameResult = new GameResult();
        this.inputCarNames = racingService.divideCarNames(inputCarNames);
        this.inputGameLap = inputGameLap;
    }

    public void startRacing() {
        List<Car> cars = racingService.createRacingGameCars(inputCarNames);
        racingGame = new RacingGame(racingService.playGame(cars, inputCarNames, inputGameLap));
        Map<String, List<Integer>> trackRecord = racingGame.getTrackRecord(inputCarNames);
        winRacingGame(trackRecord);

    }

    public void winRacingGame(Map<String, List<Integer>> trackRecord) {
        Map<String, Integer> trackRecordSum = new HashMap<>();
        for (int lap = 0; lap <= inputGameLap; lap++) {
            trackRecordSum = racingGame.getTrackRecordSum(trackRecord, lap);
            gameResult.movingCurrentCar(trackRecordSum, lap);
        }
        List<String> racingWinner = racingService.winRacingGame(trackRecordSum);
        gameResult.printRacingGameResult(racingWinner);
    }
}
