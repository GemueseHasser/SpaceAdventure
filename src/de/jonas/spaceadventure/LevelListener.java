package de.jonas.spaceadventure;

import java.util.Timer;
import java.util.TimerTask;

public class LevelListener {

    Timer timer;

    public LevelListener() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (!Variablen.isPlaying) {
                    return;
                }
                if (Variablen.level == 1) {
                    return;
                }
                if (Variablen.level == 2 && !Variablen.achievments[0]) {
                    checkoutLevel(2);
                    Variablen.achievments[0] = true;
                    return;
                }
                if (Variablen.level == 3 && !Variablen.achievments[1]) {
                    checkoutLevel(3);
                    Variablen.achievments[1] = true;
                    return;
                }
                if (Variablen.level == 4 && !Variablen.achievments[2]) {
                    checkoutLevel(4);
                    Variablen.achievments[2] = true;
                    return;
                }
                if (Variablen.level == 5 && !Variablen.achievments[3]) {
                    Variablen.achievments[3] = true;
                }
            }
        }, 0, 5);
    }

    private void checkoutLevel(int state) {
        LevelChanges changes = new LevelChanges();
        if (state == 2) {
            changes.levelTwo();
        }
        if (state == 3) {
            changes.levelThree();
        }
        if (state == 4) {
            changes.levelFour();
        }
    }

}
