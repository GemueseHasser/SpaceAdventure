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
                if (Variablen.level == 2 && !Variablen.achievments[0]) {
                    System.out.println("Player achieved level " + Variablen.level);
                    System.out.println("Do some stuff for level " + Variablen.level);
                    Variablen.achievments[0] = true;
                    return;
                }
                if (Variablen.level == 3 && !Variablen.achievments[1]) {
                    System.out.println("Player achieved level " + Variablen.level);
                    System.out.println("Do some stuff for level " + Variablen.level);
                    Variablen.achievments[1] = true;
                    return;
                }
                if (Variablen.level == 4 && !Variablen.achievments[2]) {
                    System.out.println("Player achieved level " + Variablen.level);
                    System.out.println("Do some stuff for level " + Variablen.level);
                    Variablen.achievments[2] = true;
                    return;
                }
                if (Variablen.level == 5 && !Variablen.achievments[3]) {
                    System.out.println("Player achieved level " + Variablen.level);
                    System.out.println("Do some stuff for level " + Variablen.level);
                    System.out.println("WIN!");
                    Variablen.achievments[3] = true;
                }
            }
        }, 0, 5);
    }

}
