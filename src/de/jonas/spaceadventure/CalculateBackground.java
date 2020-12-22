package de.jonas.spaceadventure;

import java.util.Timer;
import java.util.TimerTask;

public class CalculateBackground {

    Timer timer;

    public CalculateBackground() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (!Variablen.isPlaying) {
                    return;
                }
                if (Variablen.backgroundY2 >= 0) {
                    Variablen.backgroundY1 = 0;
                    Variablen.backgroundY2 = -600;
                }
                Variablen.backgroundY1++;
                Variablen.backgroundY2++;
            }
        }, 0, 5);
    }

}
