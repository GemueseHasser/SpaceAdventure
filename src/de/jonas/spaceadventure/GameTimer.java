package de.jonas.spaceadventure;

import java.util.Timer;
import java.util.TimerTask;

public class GameTimer {

    Timer timer;

    public GameTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (!Variablen.isPlaying) {
                    return;
                }
                Variablen.gameTimeSecs++;
                if (Variablen.gameTimeSecs == 60) {
                    Variablen.gameTimeMinutes++;
                    Variablen.gameTimeSecs = 0;
                }

                if (Variablen.gameTimeMinutes == 0 && Variablen.gameTimeSecs == 15) {
                    Variablen.level = 1;
                    SendTitle.sendLevel("Du hast 15 Sekunden durchgehalten!", 1);
                }

                if (Variablen.gameTimeMinutes == 0 && Variablen.gameTimeSecs == 30) {
                    Variablen.level = 2;
                    SendTitle.sendLevel("Du hast 30 Sekunden durchgehalten!", 1);
                }

                if (Variablen.gameTimeMinutes == 1 && Variablen.gameTimeSecs == 0) {
                    Variablen.level = 3;
                    SendTitle.sendLevel("Du hast eine Minute durchgehalten!", 1);
                }

                if (Variablen.gameTimeMinutes == 1 && Variablen.gameTimeSecs == 30) {
                    Variablen.level = 4;
                    SendTitle.sendLevel("Du hast gewonnen!", 2);
                    Variablen.isPlaying = false;
                    new Win();
                }

            }
        }, 0, 1000);
    }

}
