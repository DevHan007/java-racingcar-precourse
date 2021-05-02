package com.racing.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    @DisplayName("자동차 생성 테스트")
    void createCar() {
        Car car = new Car("제주항공", 0);
        assertThat(car.getCarName()).isEqualTo("제주항공");
    }

    @Test
    @DisplayName("자동차 이름 5글자 제한 체크 테스트")
    void checkCarNameLength() {
        assertThatThrownBy(() -> {
            Car car = new Car("제주항공우아한", 0);
        }).isInstanceOf(NumberFormatException.class);
    }
}