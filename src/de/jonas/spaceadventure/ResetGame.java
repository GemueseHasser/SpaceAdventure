package de.jonas.spaceadventure;

public class ResetGame {

    public ResetGame() {
        for (int i = 0; i < 5; i++) {
            Variablen.stoneY[i] = -550;
        }
        for (int i = 0; i < 3; i++) {
            Variablen.meteorY[i] = -550;
        }
        Variablen.rocketX = 320;
        Variablen.rocketY = 420;
        Variablen.left = false;
        Variablen.right = false;
        Variablen.isPlaying = true;
        Variablen.gameTimeSecs = 0;
        Variablen.gameTimeMinutes = 0;
        Variablen.level = 1;
        Variablen.showRocket = true;
        for (int i = 0; i < 3; i++) {
            Variablen.achievments[i] = false;
        }
        Variablen.activeStones = 5;
        Variablen.opponentSpeed = 10;
    }

}
