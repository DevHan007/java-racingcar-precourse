package com.racing.car;

public class Car {
    private final String carName;
    private final int position;

    public Car(String carName, int position) {
        this.carName = checkCarNameLength(carName);
        this.position = position;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    private String checkCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new NumberFormatException("자동차 이름은 5글자 이하만 가능합니다. : " + carName);
        }
        return carName;
    }
}
