package de.jonas.spaceadventure;

import java.util.Timer;
import java.util.TimerTask;

public class PlayerMovement {

    Timer timer;

    public PlayerMovement() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (!Variablen.isPlaying) {
                    return;
                }
                if (Variablen.rocketX <= -35) {
                    Variablen.rocketX++;
                    return;
                }
                if (Variablen.rocketX >= 670) {
                    Variablen.rocketX--;
                    return;
                }

                if (Variablen.left) {
                    Variablen.rocketX--;
                }

                if (Variablen.right) {
                    Variablen.rocketX++;
                }
            }
        }, 0, 5);
    }

}
