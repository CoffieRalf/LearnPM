package vl11.j2d;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Carsten Gips
 * @since 27.02.2016
 *
 */

interface GameObject {
    // Berechnung der naechsten Position
    void move();

    // Bewegungsrichtung umkehren
    void turn();

    // Beruehren sich zwei Objekte? (Wird von Rectangle bereits implementiert)
    boolean intersects(GameObject g2);

    // Objekt auf dem Graphics-Objekt zeichnen
    // Methode entspricht Observer#update()
    void paintTo(Graphics g);
}

class GRect extends Rectangle implements GameObject {
    int deltaX;

    GRect(int x, int y, int deltaX) {
        super(x, y, 80, 80);
        this.deltaX = deltaX;
    }

    @Override
    public void move() {
        translate(deltaX, 0);
        if (getX() > 300) {
            translate(-280, 0);
        } else if (getX() < 20) {
            translate(280, 0);
        }
    }

    // Methode entspricht Observer#update()
    @Override
    public void paintTo(Graphics g) {
        g.setColor(Color.BLUE);
        g.drawRect((int) getX(), (int) getY(), (int) getWidth(), (int) getHeight());
    }

    @Override
    public void turn() {
        deltaX *= -1;
    }

    @Override
    public boolean intersects(GameObject g2) {
        // nicht zu Hause nachmachen: unsauber!!!
        return this.intersects((Rectangle) g2);
    }
}

public class SimpleGame extends JPanel {
    public JButton button;
    GameObject[] gameObjs;

    public SimpleGame() {
        button = new JButton("move");
        gameObjs = new GameObject[] { new GRect(20, 20, 20), new GRect(20, 120, 10), new GRect(20, 220, 30),
                new GRect(20, 320, 10), new GRect(300, 320, -10) };

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doOneTick();
            }
        });
    }

    // Methode entspricht Observable#notify()
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        setBackground(Color.WHITE);

        for (GameObject go : gameObjs) {
            go.paintTo(g);
        }
    }

    public void doOneTick() {
        move();
        doChecks();
        repaint();
    }

    public void move() {
        for (GameObject go : gameObjs) {
            go.move();
        }
    }

    public void doChecks() {
        for (GameObject g1 : gameObjs) {
            for (GameObject g2 : gameObjs) {
                if (g1 != g2 && g1.intersects(g2)) {
                    reactWhenTouching(g1, g2);
                }
            }
        }
    }

    void reactWhenTouching(GameObject g1, GameObject g2) {
        g1.turn();
        g1.move();
        g2.turn();
        g2.move();
    }

    public static void main(String[] args) {
        JFrame f = new JFrame("Zeichenprimitive");
        SimpleGame panel = new SimpleGame();

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(panel, BorderLayout.CENTER);
        f.add(panel.button, BorderLayout.SOUTH);
        f.setSize(400, 480);
        f.setVisible(true);
    }
}
