package vl11.swing;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author Carsten Gips
 * @since 27.02.2016
 *
 * @see Idee nach Deitel&Deitel: "Java - How to Program"
 *
 */

public class TabbedPane extends JFrame {
    public TabbedPane() {
        super("TabbedFrame Demo");

        JTabbedPane t = new JTabbedPane();

        t.addTab("Tab 1", null, new JLabel("Label auf Tab1"), "Tooltip Tab 1");

        JPanel p = new JPanel();
        p.add(new JLabel("Eingabe: "));
        p.add(new JTextField("", 5));
        t.addTab("Tab 2", null, p, "Tooltip Tab 2");

        JPanel bp = new JPanel();
        bp.setLayout(new BorderLayout());
        bp.add(new JButton("north"), BorderLayout.NORTH);
        bp.add(new JButton("south"), BorderLayout.SOUTH);
        bp.add(new JButton("east"), BorderLayout.EAST);
        bp.add(new JButton("west"), BorderLayout.WEST);
        t.addTab("Tab 3", null, bp, "Tooltip Tab 3");

        JPanel scrollPanel = new JPanel();
        JTextArea text = new JTextArea(8, 26);
        JScrollPane scrollText = new JScrollPane(text);
        scrollPanel.add(scrollText);
        t.addTab("Tab 4", null, scrollPanel, "Scrollpanel");

        add(t);
    }

    public static void main(String[] args) {
        TabbedPane f = new TabbedPane();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(400, 200);
        f.setVisible(true);
    }
}
