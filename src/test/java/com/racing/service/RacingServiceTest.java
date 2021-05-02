package com.racing.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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

}