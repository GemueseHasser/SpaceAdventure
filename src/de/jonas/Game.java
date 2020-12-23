package de.jonas;

import de.jonas.spaceadventure.CalculateBackground;
import de.jonas.spaceadventure.CalculateOpponents;
import de.jonas.spaceadventure.CheckCollision;
import de.jonas.spaceadventure.GUI;
import de.jonas.spaceadventure.GameTimer;
import de.jonas.spaceadventure.ImageLoader;
import de.jonas.spaceadventure.LevelListener;
import de.jonas.spaceadventure.PlayerMovement;
import de.jonas.spaceadventure.WriteInfosInConfig;

public class Game {

    public static void main(String[] args) {
        new GUI();
        new ImageLoader();
        new CalculateBackground();
        new PlayerMovement();

        CalculateOpponents opponents = new CalculateOpponents();
        opponents.initialize();

        new CalculateOpponents();
        new CheckCollision();
        new GameTimer();
        new LevelListener();
        new WriteInfosInConfig();
    }

}
