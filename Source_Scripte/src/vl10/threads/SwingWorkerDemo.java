package vl10.threads;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

/**
 * @author Carsten Gips
 * @since 27.02.2016
 *
 */

public class SwingWorkerDemo extends JFrame {
    JTextField in1;
    JTextField in2;
    JLabel erg1;
    JLabel erg2;

    public SwingWorkerDemo() {
        super("SwingWorker Demo");
        JTabbedPane t = new JTabbedPane();
        createBlockingPanel(t);
        createSwingWorkerPanel(t);
        add(t);
    }

    private void createBlockingPanel(JTabbedPane t) {
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(2, 2, 5, 5));
        p1.add(new JLabel("Fibonacci for: "));
        in1 = new JTextField("0", 5);
        in1.setToolTipText("try 42 :-)");
        p1.add(in1);
        JButton b1 = new JButton("GO");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                erg1.setText("Ergebnis: " + fibonacci(Integer.valueOf(in1.getText())));
            }
        });
        p1.add(b1);
        erg1 = new JLabel("");
        p1.add(erg1);
        t.addTab("Fibonacci", null, p1, "Fiboccizahlen ohne Thread");
    }

    private void createSwingWorkerPanel(JTabbedPane t) {
        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(2, 2, 5, 5));
        p2.add(new JLabel("Fibonacci for: "));
        in2 = new JTextField("0", 5);
        in2.setToolTipText("try 42 :-)");
        p2.add(in2);
        JButton b2 = new JButton("GO");
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingWorker<String, Object> task = new SwingWorker<String, Object>() {
                    @Override
                    protected String doInBackground() throws Exception {
                        erg2.setText("calculating ...");
                        return "Ergebnis: " + fibonacci(Integer.valueOf(in2.getText()));
                    }

                    @Override
                    protected void done() {
                        try {
                            erg2.setText(get());
                        } catch (Exception e) {
                            erg2.setText("Exception - Berechnung unterbrochen");
                        }
                    }
                };
                task.execute();
            }
        });
        p2.add(b2);
        erg2 = new JLabel("");
        p2.add(erg2);
        t.addTab("Tread-Fibonacci", null, p2, "Fiboccizahlen mit SwingWorker");
    }

    protected long fibonacci(long number) {
        if (number == 0 || number == 1) {
            return number;
        } else {
            return fibonacci(number - 1) + fibonacci(number - 2);
        }
    }

    public static void main(String[] args) {
        SwingWorkerDemo f = new SwingWorkerDemo();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(400, 100);
        f.setVisible(true);
    }
}
