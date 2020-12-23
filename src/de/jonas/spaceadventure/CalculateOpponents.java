package de.jonas.spaceadventure;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class CalculateOpponents {

    Timer timer;
    Random random;

    public CalculateOpponents() {
        timer = new Timer();
        random = new Random();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                for (int i = 0; i < Variablen.activeStones; i++) {
                    if (Variablen.stoneY[i] >= 600 || Variablen.stoneY[i] == -550) {
                        Variablen.stoneX[i] = random.nextInt(780 - 20 + 1) + 20;
                        Variablen.stoneY[i] = random.nextInt(-20 + 500 + 1) - 500;
                    } else {
                        Variablen.stoneY[i]++;
                    }
                }
                for (int i = 0; i < 3; i++) {
                    if (Variablen.meteorY[i] >= 600 || Variablen.meteorY[i] == -550) {
                        Variablen.meteorX[i] = random.nextInt(780 - 20 + 1) + 20;
                        Variablen.meteorY[i] = random.nextInt(-20 + 500 + 1) - 500;
                    } else {
                        Variablen.meteorY[i]++;
                    }
                }
            }
        }, 0, Variablen.opponentSpeed);
    }

    public void initialize() {
        for (int i = 0; i < 5; i++) {
            Variablen.stoneY[i] = -550;
        }
        for (int i = 0; i < 3; i++) {
            Variablen.meteorY[i] = -550;
        }
    }

}
