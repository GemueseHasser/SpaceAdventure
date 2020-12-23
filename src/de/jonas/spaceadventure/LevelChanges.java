package de.jonas.spaceadventure;

public class LevelChanges {

    public void levelTwo() {
        System.out.println("--------------------------");
        System.out.println("Level 2");
        Variablen.opponentSpeed = 1;
        System.out.println("make opponents a bit faster");
        Variablen.activeStones = 8;
        System.out.println("Set active stones from 5 to 8");
        System.out.println("--------------------------");
    }

    public void levelThree() {
        System.out.println("--------------------------");
        System.out.println("Level 3");
        Variablen.opponentSpeed = 11;
        new CalculateOpponents();
        System.out.println("Make opponents much faster");
        Variablen.activeStones = 10;
        System.out.println("Set active stones from 8 to 10");
        System.out.println("--------------------------");
    }

    public void levelFour() {
        System.out.println("--------------------------");
        System.out.println("Level 4");
        Variablen.activeMeteors = 5;
        System.out.println("Set active meteors from 3 to 5");
        Variablen.activeStones = 11;
        System.out.println("Set active stones from 10 to 11");
        System.out.println("--------------------------");
    }

}
