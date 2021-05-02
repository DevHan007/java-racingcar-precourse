package com.racing.service;

import com.racing.car.Car;

import java.util.*;

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

    public List<String> winRacingGame(Map<String, Integer> racingGameMap) {
        int winnerPosition = getWinnerPosition(racingGameMap);
        List<String> winners = new ArrayList<>();
        for (String mapKey : racingGameMap.keySet()) {
            winners = checkRacingWinner(racingGameMap, winners, winnerPosition, mapKey);
        }
        return winners;
    }

    private int getWinnerPosition(Map<String, Integer> racingGameMap) {
        List<Integer> carPositions = new ArrayList<>();
        for (String mapKey : racingGameMap.keySet()) {
            carPositions.add(racingGameMap.get(mapKey));
        }
        return Collections.max(carPositions);
    }

    private List<String> checkRacingWinner(Map<String, Integer> racingGameMap, List<String> winners, int winnerPosition, String key) {
        if (racingGameMap.get(key) == winnerPosition) {
            winners.add(key);
        }
        return winners;
    }

    public static int getTrackCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        Scanner scanner = new Scanner(System.in);
        String inputNumber = scanner.nextLine();
        return Integer.parseInt(inputNumber.trim());
    }

    public static String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)기준으로 구분)");
        Scanner scanner = new Scanner(System.in);
        String inputCarName = scanner.nextLine();
        return inputCarName.replace(" ", "");
    }
}
