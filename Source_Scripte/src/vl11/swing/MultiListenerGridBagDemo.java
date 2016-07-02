package vl11.swing;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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

public class MultiListenerGridBagDemo extends JFrame {
    public MultiListenerGridBagDemo() {
        super("MultListener Demo");

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.weighty = 0.0;
        c.gridx = 0;
        c.gridy = 0;
        add(new JLabel("Listener mehrfach"), c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.weighty = 0.0;
        c.gridx = 1;
        c.gridy = 0;
        add(new JLabel("Mehrere Listener"), c);

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.5;
        c.weighty = 1.0;
        c.gridheight = 4;
        c.gridx = 0;
        c.gridy = 1;
        JTextArea singleListener = new JTextArea(5, 10);
        add(new JScrollPane(singleListener), c);

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.5;
        c.weighty = 1.0;
        c.gridheight = 4;
        c.gridx = 1;
        c.gridy = 1;
        JTextArea multiListener = new JTextArea(5, 10);
        add(new JScrollPane(multiListener), c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.weighty = 0.0;
        c.gridx = 0;
        c.gridy = 5;
        JButton singleButton = new JButton("single listener");
        add(singleButton, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.weighty = 0.0;
        c.gridx = 1;
        c.gridy = 5;
        JButton multiButton = new JButton("multi listener");
        add(multiButton, c);

        Handler single = new Handler(singleListener);
        Handler m1 = new Handler(multiListener);
        Handler m2 = new Handler(multiListener);
        singleButton.addActionListener(single);
        multiButton.addActionListener(single);
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
        MultiListenerGridBagDemo f = new MultiListenerGridBagDemo();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(300, 200);
        f.setVisible(true);
    }
}
