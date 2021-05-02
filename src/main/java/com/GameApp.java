package com;

import com.racing.RacingGameApp;
import com.racing.service.RacingService;

public class GameApp {
    public static void main(String[] args) {
        try {
            RacingGameApp racingGameApp = new RacingGameApp(RacingService.getCarNames(),RacingService.getTrackCount());
            racingGameApp.startRacing();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
