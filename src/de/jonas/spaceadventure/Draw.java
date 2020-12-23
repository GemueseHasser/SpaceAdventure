package de.jonas.spaceadventure;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class Draw extends JLabel {


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g.drawImage(
            ImageLoader.space,
            Variablen.backgroundX1,
            Variablen.backgroundY1,
            this.getWidth(),
            this.getHeight(),
            null
        );

        g.drawImage(
            ImageLoader.space,
            Variablen.backgroundX2,
            Variablen.backgroundY2,
            this.getWidth(),
            this.getHeight(),
            null
        );

        if (Variablen.showRocket) {
            g.drawImage(
                ImageLoader.rocket,
                Variablen.rocketX,
                Variablen.rocketY,
                150,
                150,
                null
            );
        }

        for (int i = 0; i < 4; i++) {
            g.drawImage(
                ImageLoader.stone,
                Variablen.stoneX[i],
                Variablen.stoneY[i],
                50,
                50,
                null
            );
        }

        for (int i = 4; i < Variablen.activeStones; i++) {
            g.drawImage(
                ImageLoader.stone,
                Variablen.stoneX[i],
                Variablen.stoneY[i],
                60,
                60,
                null
            );
        }

        for (int i = 0; i < 3; i++) {
            g.drawImage(
                ImageLoader.meteor,
                Variablen.meteorX[i],
                Variablen.meteorY[i],
                80,
                90,
                null
            );
        }

        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.setColor(Color.WHITE);

        if (Variablen.gameTimeSecs < 10) {
            g.drawString("Zeit: " + Variablen.gameTimeMinutes + ":0" + Variablen.gameTimeSecs, 20, 30);
        } else {
            g.drawString("Zeit: " + Variablen.gameTimeMinutes + ":" + Variablen.gameTimeSecs, 20, 30);
        }

        if (Variablen.moveLine) {
            if (Variablen.gameTimeMinutes == 1 && Variablen.gameTimeSecs >= 20) {
                g.setColor(Color.RED);
                g.fillRect(0, Variablen.lineY, this.getWidth(), 20);
            } else {
                g.setColor(Color.GREEN);
                g.fillRect(0, Variablen.lineY, this.getWidth(), 6);
            }
        }

        repaint();
    }


}
