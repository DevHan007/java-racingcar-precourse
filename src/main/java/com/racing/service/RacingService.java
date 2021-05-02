package com.racing.service;

import java.util.Arrays;
import java.util.List;

public class RacingService {

    public List<String> divideCarNames(String inputCarNames) {
        return Arrays.asList(inputCarNames.split(","));
    }

}
