package de.jonas.spaceadventure;

import java.util.Timer;
import java.util.TimerTask;

public class GameTimer {

    Timer timer, timerII;

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

                if ((Variablen.gameTimeMinutes == 0 && (Variablen.gameTimeSecs == 13 || Variablen.gameTimeSecs == 28 || Variablen.gameTimeSecs == 58)) ||
                    (Variablen.gameTimeMinutes == 1 && Variablen.gameTimeSecs == 28)) {
                    makeLine();
                }

            }
        }, 0, 1000);
    }

    private void makeLine() {
        Variablen.lineY = 0;
        timerII = new Timer();
        timerII.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (Variablen.lineY <= 420) {
                    Variablen.moveLine = true;
                    Variablen.lineY++;
                } else {
                    Variablen.moveLine = false;

                    if (Variablen.gameTimeMinutes == 0 && Variablen.gameTimeSecs >= 13 && Variablen.gameTimeSecs <= 17) {
                        Variablen.level = 2;
                        SendTitle.sendLevel("Du hast 15 Sekunden durchgehalten!", 1);
                    }

                    if (Variablen.gameTimeMinutes == 0 && Variablen.gameTimeSecs >= 28 && Variablen.gameTimeSecs <= 32) {
                        Variablen.level = 3;
                        SendTitle.sendLevel("Du hast 30 Sekunden durchgehalten!", 1);
                    }

                    if ((Variablen.gameTimeMinutes == 0 && Variablen.gameTimeSecs >= 58) ||
                        (Variablen.gameTimeMinutes == 1 && Variablen.gameTimeSecs <= 2)) {
                        Variablen.level = 4;
                        SendTitle.sendLevel("Du hast eine Minute durchgehalten!", 1);
                    }

                    if (Variablen.gameTimeMinutes == 1 && Variablen.gameTimeSecs >= 28 && Variablen.gameTimeSecs <= 32) {
                        Variablen.level = 5;
                        Variablen.isPlaying = false;
                        Variablen.showRocket = false;
                        new Win();
                    }

                    timerII.cancel();
                }
            }
        }, 0, 5);
    }

}
