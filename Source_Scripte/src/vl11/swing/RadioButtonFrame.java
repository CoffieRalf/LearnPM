package vl11.swing;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * @author Carsten Gips
 * @since 27.02.2016
 *
 * @see Idee nach Deitel&Deitel: "Java - How to Program"
 *
 */

public class RadioButtonFrame extends JFrame {
    private JTextField text;
    private JRadioButton b1, b2, b3;
    private ButtonGroup radioGroup;

    public RadioButtonFrame() {
        super("RadioButton Test");
        setLayout(new FlowLayout());

        text = new JTextField("", 10);
        add(text);

        b1 = new JRadioButton("Button 1", true);
        b2 = new JRadioButton("Button 2", false);
        b3 = new JRadioButton("Button 3", false);
        add(b1);
        add(b2);
        add(b3);

        radioGroup = new ButtonGroup();
        radioGroup.add(b1);
        radioGroup.add(b2);
        radioGroup.add(b3);

        b1.addItemListener(new Handler(b1.getText()));
        b2.addItemListener(new Handler(b2.getText()));
        b3.addItemListener(new Handler(b3.getText()));
    }

    private class Handler implements ItemListener {
        private String name;

        public Handler(String n) {
            name = n;
        }

        @Override
        public void itemStateChanged(ItemEvent e) {
            text.setText(name);
        }
    }

    public static void main(String[] args) {
        RadioButtonFrame f = new RadioButtonFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(460, 60);
        f.setVisible(true);
    }
}
