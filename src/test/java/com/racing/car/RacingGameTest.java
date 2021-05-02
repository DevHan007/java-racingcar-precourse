package com.racing.car;


import com.racing.service.RacingService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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

}