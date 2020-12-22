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
                if (Variablen.level == 1) {
                    return;
                }
                System.out.println("Player achieved level " + Variablen.level);
                System.out.println("Do some stuff for level " + Variablen.level);
            }
        }, 0, 5);
    }

}
