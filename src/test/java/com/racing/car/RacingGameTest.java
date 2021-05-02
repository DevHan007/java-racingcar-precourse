package com.racing.car;


import com.racing.service.RacingService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class RacingGameTest {

    @Test
    @DisplayName("전제 GameLaps를 진행한 후 자동차 정보 일급컬렉션으로 전환하는 테스트")
    void playGame() {
        RacingService racingService = new RacingService();
        List<String> divideCarNames = racingService.divideCarNames("123,1234,12354,1235");
        List<Car> resultCarNames = racingService.createRacingGameCars(divideCarNames);
        List<Car> cars = racingService.playGame(resultCarNames, divideCarNames, 5);
        RacingGame racingGame = new RacingGame(cars);
        assertThat(racingGame.getRacingGameCars())
                .hasSize(24)
                .filteredOn(car -> "123".equals(car.getCarName()))
                .hasSize(6);
    }

    @Test
    @DisplayName("전체 GameLaps 진행 후 이름 기준으로 분리 테스트")
    void getTrackRecord() {
        RacingService racingService = new RacingService();
        List<String> divideCarNames = racingService.divideCarNames("하하하,제주항공,아키스,우아한형제");
        List<Car> carList = Arrays.asList(
                new Car("하하하",0),
                new Car("제주항공",0),
                new Car("아키스",0),
                new Car("우아한형제",0),
                new Car("하하하",1),
                new Car("제주항공",0),
                new Car("아키스",1),
                new Car("우아한형제",0)
        );
        RacingGame racingGame = new RacingGame(carList);
        Map<String, List<Integer>> trackRecord = racingGame.getTrackRecord(divideCarNames);
        assertThat(trackRecord)
                .containsKeys("하하하", "제주항공","아키스", "우아한형제");

    }

    @Test
    @DisplayName("GameLap 별로 각 자동차 객체 누적 position 정보 추출하는 테스트")
    void getTrackRecordSum() {
        RacingService racingService = new RacingService();
        List<String> divideCarNames = racingService.divideCarNames("하하하,제주항공,아키스,우아한형제");
        List<Car> carList = Arrays.asList(
                new Car("하하하",0),
                new Car("제주항공",0),
                new Car("아키스",0),
                new Car("우아한형제",0),
                new Car("하하하",1),
                new Car("제주항공",0),
                new Car("아키스",1),
                new Car("우아한형제",0),
                new Car("하하하",1),
                new Car("제주항공",1),
                new Car("아키스",1),
                new Car("우아한형제",0)
        );
        RacingGame racingGame = new RacingGame(carList);
        Map<String, List<Integer>> trackRecord = racingGame.getTrackRecord(divideCarNames);
        Map<String, Integer> trackRecordSum = racingGame.getTrackRecordSum(trackRecord, 2);
        assertThat(trackRecordSum)
                .containsKeys("하하하", "제주항공","아키스", "우아한형제")
                .containsValues(2,1,2,0);

    }

}