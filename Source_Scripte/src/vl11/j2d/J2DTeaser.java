package vl11.j2d;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * @author Carsten Gips
 * @since 26.02.2016
 *
 */

abstract class AbstrGameObj {
    int x, y, deltaX;
    Color c;

    AbstrGameObj(int x, int y, int deltaX, Color c) {
        this.x = x;
        this.y = y;
        this.deltaX = deltaX;
        this.c = c;
    }

    void move() {
        x += deltaX;
    }

    void paintTo(Graphics g) {
        g.setColor(c);
        if (x > 380) {
            x = 20;
        }
        draw(g);
    }

    abstract void draw(Graphics g);
}

class GameRect extends AbstrGameObj {
    GameRect(int x, int y, int deltaX) {
        super(x, y, deltaX, Color.BLUE);
    }

    @Override
    void draw(Graphics g) {
        g.drawRect(x, y, 80, 80);
    }
}

class GameOval extends AbstrGameObj {
    GameOval(int x, int y, int deltaX) {
        super(x, y, deltaX, Color.GREEN);
    }

    @Override
    void draw(Graphics g) {
        g.fillOval(x, y, 80, 80);
    }
}

class GameString extends AbstrGameObj {
    double rot = 0;
    Random rand;

    GameString(int x, int y, int deltaX) {
        super(x, y, deltaX, Color.RED);
        rand = new Random();
    }

    @Override
    void move() {
        super.move();
        rot -= 0.06;
    }

    @Override
    void draw(Graphics g) {
        ((Graphics2D) g).rotate(rot);
        if (rand.nextBoolean()) {
            g.setColor(Color.RED);
        } else {
            g.setColor(Color.YELLOW);
        }
        g.setFont(new Font("Serif", Font.BOLD, 12));
        g.drawString("Serif, 12pt, fett", x, y);
        ((Graphics2D) g).rotate(-rot);
    }
}

public class J2DTeaser extends JPanel {
    public JButton button;
    AbstrGameObj[] gameObjs;

    public J2DTeaser() {
        button = new JButton("move");
        gameObjs = new AbstrGameObj[] { new GameRect(20, 20, 20), new GameOval(20, 120, 10),
                new GameString(20, 220, 1) };

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doOneTick();
            }
        });

        Timer t = new Timer(2000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                doOneTick();
            }
        });
        t.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);

        for (AbstrGameObj go : gameObjs) {
            go.paintTo(g);
        }
    }

    public synchronized void doOneTick() {
        for (AbstrGameObj go : gameObjs) {
            go.move();
        }
        repaint();
    }

    public static void main(String[] args) {
        JFrame f = new JFrame("Zeichenprimitive");
        J2DTeaser panel = new J2DTeaser();

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(panel, BorderLayout.CENTER);
        f.add(panel.button, BorderLayout.SOUTH);
        f.setSize(400, 460);
        f.setVisible(true);
    }
}
