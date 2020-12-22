package de.jonas.spaceadventure;

import java.util.Timer;
import java.util.TimerTask;

public class CheckCollision {

    Timer timer;

    public CheckCollision() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (!Variablen.isPlaying) {
                    return;
                }
                for (int i = 0; i < 5; i++) {
                    if (Variablen.stoneX[i] >= Variablen.rocketX && Variablen.stoneX[i] <= Variablen.rocketX + 75) {
                        if (Variablen.stoneY[i] >= 385 && Variablen.stoneY[i] <= 400) {
                            Variablen.isPlaying = false;
                            new Lose();
                        }
                    }
                }
                for (int i = 0; i < 3; i++) {
                    if (Variablen.meteorX[i] >= Variablen.rocketX && Variablen.meteorX[i] <= Variablen.rocketX + 75) {
                        if (Variablen.meteorY[i] >= 370 && Variablen.meteorY[i] <= 400) {
                            Variablen.isPlaying = false;
                            new Lose();
                        }
                    }
                }
            }
        }, 0, 4);
    }

}
