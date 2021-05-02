package com.racing.ui;

import java.util.List;
import java.util.Map;

public class GameResult {

    public void movingCurrentCar(Map<String, Integer> recordSum, int lap) {
        if (lap == 0) {
            startGameResult();
            return;
        }
        printMovingCar(recordSum,lap);
    }

    public void startGameResult() {
        System.out.println("실행결과");
    }

    public void printMovingCar(Map<String, Integer> recordSum, int lap) {
        for (String mapKey : recordSum.keySet()) {
            System.out.print(mapKey + " : ");
            System.out.println(appendDistance(recordSum.get(mapKey)));
        }
        System.out.println();
    }

    public String appendDistance(int position) {
        String distance = "";
        for (int i = 0; i < position; i++) {
            distance = distance + "-";
        }
        return distance;
    }

    public void printRacingGameResult(List<String> racingWinner) {
        if (racingWinner.size() == 1) {
            printRacingOneWinner(racingWinner);
            return;
        }
        printRacingMultiWinner(racingWinner);

    }

    public void printRacingOneWinner(List<String> racingWinner) {
        for (String winner : racingWinner) {
            System.out.print(winner);
            System.out.println(" 가 최종 우승했습니다.");
        }
    }

    public void printRacingMultiWinner(List<String> racingWinner) {
        for (String winner : racingWinner) {
            System.out.print(winner + ",");
        }
        System.out.println(" 가 최종 우승했습니다.");
    }

}
