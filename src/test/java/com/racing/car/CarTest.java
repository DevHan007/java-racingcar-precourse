package com.racing.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("자동차 생성 테스트")
    void createCar() {
        Car car = new Car("제주항공", 0);
        assertThat(car.getCarName()).isEqualTo("제주항공");
    }

}