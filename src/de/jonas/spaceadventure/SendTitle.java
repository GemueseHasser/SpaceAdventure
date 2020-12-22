package de.jonas.spaceadventure;

import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SendTitle extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;

    private final Font font = new Font("Impact", Font.PLAIN, 70);

    private final String message;
    private static JWindow window;

    private Timer timer;
    private int time;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setFont(font);
        g2.setColor(Color.RED);
        String text = message;
        int width = g.getFontMetrics().stringWidth(text);
        g2.drawString(text, getWidth() / 2 - width / 2, getHeight() / 2);
        Graphics2D g3 = (Graphics2D) g;
        g3.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g3.setFont(font);
        g3.setColor(Color.GREEN);
        String textI = "Level " + Variablen.level + "!";
        int widthI = g.getFontMetrics().stringWidth(textI);
        g3.drawString(textI, getWidth() / 2 - widthI / 2, 350);
    }

    public SendTitle(
        final String message,
        final int duration
    ) {
        this.message = message;
        setOpaque(false);
        setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height));
        time = duration;
        timer = new Timer(1000, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        time--;
        if(time == 0) {
            timer.stop();
            window.dispose();
        }
        repaint();
    }

    static JWindow sendLevel (
        final String message,
        final int durationInSeconds
    ) {
        window = new JWindow();
        window.add(new SendTitle(
            message,
            durationInSeconds
        ));
        window.pack();
        window.setBackground(new Color(0, 0, 0, 0));
        window.setLocationRelativeTo(null);
        window.toFront();
        window.setAlwaysOnTop(true);
        window.setVisible(true);
        return window;
    }

}
