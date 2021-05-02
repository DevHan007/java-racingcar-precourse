package com.racing.service;

public enum MovingType {
    GO(1),
    STOP(0);

    private final int movingValue;

    MovingType(int movingValue) {
        this.movingValue = movingValue;
    }

    public int getMovingValue() {
        return movingValue;
    }
}
