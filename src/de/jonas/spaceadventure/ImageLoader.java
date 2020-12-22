package de.jonas.spaceadventure;

import javax.imageio.ImageIO;

import java.awt.Image;
import java.io.IOException;

public class ImageLoader {

    static Image space, rocket, meteor, stone;

    public ImageLoader() {
        try {
            space = ImageIO.read(getClass().getResource("/de/jonas/res/spaceZoom.png"));
            rocket = ImageIO.read(getClass().getResource("/de/jonas/res/rocket.png"));
            meteor = ImageIO.read(getClass().getResource("/de/jonas/res/meteor.png"));
            stone = ImageIO.read(getClass().getResource("/de/jonas/res/stone.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
