package de.jonas.spaceadventure;

import javax.swing.JFrame;

public class GUI {

    public GUI() {
        JFrame frame = new JFrame("Space-Adventure - by Jonas");
        frame.setBounds(0, 0, 800, 600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.addKeyListener(new KeyHandler());

        Draw draw = new Draw();
        draw.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        draw.setVisible(true);

        frame.add(draw);
        frame.setVisible(true);
    }

}
