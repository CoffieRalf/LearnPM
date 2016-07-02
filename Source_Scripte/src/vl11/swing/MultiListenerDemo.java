package vl11.swing;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * @author Carsten Gips
 * @since 27.02.2016
 *
 * @see Idee nach Java-SE-7-Tutorial, Oracle.com
 *
 */

public class MultiListenerDemo extends JFrame {
    public MultiListenerDemo() {
        super("MultListener Demo");

        setLayout(new GridLayout(3, 2));

        add(new JLabel("Listener mehrfach"));
        add(new JLabel("Mehrere Listener"));

        JTextArea singleListener = new JTextArea(5, 10);
        add(new JScrollPane(singleListener));

        JTextArea multiListener = new JTextArea(5, 10);
        add(new JScrollPane(multiListener));

        JButton singleButton = new JButton("single listener");
        add(singleButton);
        JButton multiButton = new JButton("multi listener");
        add(multiButton);

        // ein Listener kann bei mehreren Observables registriert werden
        Handler single = new Handler(singleListener);
        singleButton.addActionListener(single);
        multiButton.addActionListener(single);

        // ein Observable kann mehrere Listener bedienen
        Handler m1 = new Handler(multiListener);
        Handler m2 = new Handler(multiListener);
        multiButton.addActionListener(m1);
        multiButton.addActionListener(m2);
    }

    private class Handler implements ActionListener {
        private JTextArea t;

        public Handler(JTextArea t) {
            this.t = t;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            t.append(e.getActionCommand() + "\n");
        }
    }

    public static void main(String[] args) {
        MultiListenerDemo f = new MultiListenerDemo();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(300, 200);
        f.setVisible(true);
    }

}
