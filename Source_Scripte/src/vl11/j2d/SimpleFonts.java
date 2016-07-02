package vl11.j2d;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Carsten Gips
 * @since 27.02.2016
 *
 * @see Idee nach Deitel&Deitel: "Java - How to Program"
 *
 */

public class SimpleFonts extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);

        g.setFont(new Font("Serif", Font.BOLD, 12));
        g.drawString("Serif, 12pt, fett", 20, 30);

        g.setFont(new Font("Monospaced", Font.ITALIC, 18));
        g.drawString("Mono, 18pt, schraeg", 20, 60);

        g.setColor(Color.RED);
        g.setFont(new Font("SansSerif", Font.BOLD + Font.ITALIC, 24));
        g.drawString("SansSerif, 24pt, fett und schraeg", 20, 90);
    }

    public static void main(String[] args) {
        JFrame f = new JFrame("Umgang mit Fonts");
        SimpleFonts panel = new SimpleFonts();

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(panel);
        f.setSize(550, 150);
        f.setVisible(true);
    }
}
