package vl11.swing;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;

/**
 * @author Carsten Gips
 * @since 27.02.2016
 *
 * @see Idee nach Deitel&Deitel: "Java - How to Program"
 *
 */

public class PopupFrame extends JFrame {
    private JPopupMenu kontextMenu;
    private JRadioButtonMenuItem blue, red, green;

    public PopupFrame() {
        super("PopupFrame Demo");

        blue = new JRadioButtonMenuItem("Blau");
        red = new JRadioButtonMenuItem("Rot");
        green = new JRadioButtonMenuItem("Gruen");

        blue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().setBackground(Color.BLUE);
            }
        });
        red.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().setBackground(Color.RED);
            }
        });
        green.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().setBackground(Color.GREEN);
            }
        });

        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(blue);
        radioGroup.add(red);
        radioGroup.add(green);

        kontextMenu = new JPopupMenu();
        kontextMenu.add(blue);
        kontextMenu.add(red);
        kontextMenu.add(green);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    kontextMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });

        setBackground(Color.WHITE);
    }

    public static void main(String[] args) {
        PopupFrame f = new PopupFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(300, 200);
        f.setVisible(true);
    }
}
