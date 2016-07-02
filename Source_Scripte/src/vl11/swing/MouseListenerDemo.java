package vl11.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Carsten Gips
 * @since 27.02.2016
 *
 * @see Idee nach Deitel&Deitel: "Java - How to Program"
 *
 */

public class MouseListenerDemo extends JFrame {
    private JPanel panel;
    private JLabel label;

    public MouseListenerDemo() {
        super("MouseListener Demo");

        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        add(panel, BorderLayout.CENTER);

        label = new JLabel("Statusleiste");
        add(label, BorderLayout.SOUTH);

        // Anonyme innere Klasse
        // MouseListener => *ALLE* Methoden aus Interface implementieren!
        panel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                label.setText("Clicked: (" + e.getX() + ", " + e.getY() + ")");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                label.setText("Pressed: (" + e.getX() + ", " + e.getY() + ")");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                label.setText("Released: (" + e.getX() + ", " + e.getY() + ")");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                label.setText("Entered at: (" + e.getX() + ", " + e.getY() + ")");
                panel.setBackground(Color.GREEN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label.setText("Exited");
                panel.setBackground(Color.WHITE);
            }
        });
    }

    public static void main(String[] args) {
        MouseListenerDemo f = new MouseListenerDemo();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(300, 200);
        f.setVisible(true);
    }
}
