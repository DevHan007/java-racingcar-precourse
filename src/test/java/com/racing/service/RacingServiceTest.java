package com.racing.service;

import com.racing.car.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class RacingServiceTest {

    @Test
    @DisplayName("자동차 이름을 쉼표(,)를 기준으로 나누는 테스트")
    void divideCarNameList() {
        RacingService racingService = new RacingService();
        List<String> resultCarNames = racingService.divideCarNames("123,1234,12354,1235");
        assertThat(resultCarNames)
                .hasSize(4)
                .contains("123")
                .contains("1234")
                .contains("12354")
                .contains("1235");
    }

    @Test
    @DisplayName("분리된 이름으로 각각의 자동차객체 최초생성 테스트")
    void createRacingGameCars() {
        RacingService racingService = new RacingService();
        List<String> divideCarNames = racingService.divideCarNames("123,1234,12354,1235");
        List<Car> resultCarNames = racingService.createRacingGameCars(divideCarNames);
        assertThat(resultCarNames)
                .hasSize(4)
                .extracting("carName")
                .contains("123", "1234", "12354", "1235");
    }

    @Test
    @DisplayName("자동차 전진 테스트")
    void movingForwardCar() {
        RacingService racingService = new RacingService();
        MovingType movingType = racingService.movingTypeCheck(4);
        assertThat(movingType).isEqualTo(MovingType.GO);
    }

    @Test
    @DisplayName("자동차 중지 테스트")
    void movingStopCar() {
        RacingService racingService = new RacingService();
        MovingType movingType = racingService.movingTypeCheck(3);
        assertThat(movingType).isEqualTo(MovingType.STOP);
    }

    @Test
    @DisplayName("전제 GameLaps를 진행한 후 자동차 정보 저장하는 기능 테스트")
    void playGame() {
        RacingService racingService = new RacingService();
        List<String> divideCarNames = racingService.divideCarNames("123,1234,12354,1235");
        List<Car> resultCarNames = racingService.createRacingGameCars(divideCarNames);
        List<Car> cars = racingService.playGame(resultCarNames, divideCarNames, 5);
        assertThat(cars)
                .hasSize(24)
                .filteredOn(car -> "123".equals(car.getCarName()))
                .hasSize(6);
    }

    @Test
    @DisplayName("최종 우승자 선정 테스트 ")
    void getWinner() {
        RacingService racingService = new RacingService();
        Map<String, Integer> racingGameMap = new HashMap<>();
        racingGameMap.put("하하하", 5);
        racingGameMap.put("우아한", 5);
        racingGameMap.put("제주항공", 4);
        racingGameMap.put("아키스", 1);

        List<String> racingWinner = racingService.winRacingGame(racingGameMap);
        assertThat(racingWinner)
                .contains("하하하", "우아한");


    }

}