package de.jonas.spaceadventure;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

public class Lose {

    Font font = new Font("Arial", Font.BOLD, 17);
    Font textFont = new Font("Arial", Font.BOLD, 14);

    public Lose() {
        JFrame frame = new JFrame("Autsch... Kollision :/");
        frame.setBounds(0, 0, 300, 200);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        JLabel label = new JLabel("Du hast es bis Level " + Variablen.level + " geschafft!", JLabel.CENTER);
        label.setFont(textFont);
        label.setBounds(0, 25, frame.getWidth(), 20);

        JButton button = new JButton("Erneut spielen");
        button.setFont(font);
        button.setBounds(45, 65, 200, 30);
        button.setOpaque(true);
        button.setBackground(Color.GRAY);
        button.setForeground(Color.WHITE);
        button.addActionListener(actionEvent -> {
            frame.dispose();
            new ResetGame();
        });

        JButton exit = new JButton("Spiel beenden");
        exit.setFont(font);
        exit.setBounds(45, 100, 200, 30);
        exit.setOpaque(true);
        exit.setBackground(Color.GRAY);
        exit.setForeground(Color.WHITE);
        exit.addActionListener(actionEvent -> System.exit(0));

        frame.add(label);
        frame.add(button);
        frame.add(exit);
        frame.setVisible(true);
    }

}
