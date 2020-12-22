package de.jonas.spaceadventure;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
            Variablen.left = true;
        } else if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
            Variablen.right = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
            Variablen.left = false;
        } else if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
            Variablen.right = false;
        }
    }
}
