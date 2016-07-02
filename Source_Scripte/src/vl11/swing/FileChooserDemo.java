package vl11.swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileFilter;

/**
 * @author Carsten Gips
 * @since 27.02.2016
 *
 * @see Idee nach Java-SE-7-Tutorial, Oracle.com
 *
 */

public class FileChooserDemo extends JFrame {
    JButton openButton, saveButton;
    JTextArea log;

    public FileChooserDemo() {
        super("FileChooser Demo");
        setLayout(new BorderLayout());

        log = new JTextArea(5, 20);
        log.setEditable(false);
        JScrollPane logScrollPane = new JScrollPane(log);

        openButton = new JButton("Open ...");
        saveButton = new JButton("Save ...");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(openButton);
        buttonPanel.add(saveButton);

        add(buttonPanel, BorderLayout.NORTH);
        add(logScrollPane, BorderLayout.CENTER);

        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser("/home/cagix/");
                // fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                // fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                // fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

                fc.setFileFilter(new FileFilter() {
                    @Override
                    public boolean accept(File f) {
                        if (f.getName().endsWith(".pdf")) {
                            return true;
                        }
                        return false;
                    }

                    @Override
                    public String getDescription() {
                        return ".pdf";
                    }
                });

                int returnVal = fc.showOpenDialog(FileChooserDemo.this);

                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    log.append("Would open: " + fc.getSelectedFile().getName() + "\n");
                } else {
                    log.append("Open command cancelled by user.\n");
                }
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                int returnVal = fc.showSaveDialog(FileChooserDemo.this);

                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    log.append("Would save: " + fc.getSelectedFile().getName() + "\n");
                } else {
                    log.append("Save command cancelled by user.\n");
                }
            }
        });
    }

    public static void main(String[] args) {
        FileChooserDemo f = new FileChooserDemo();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(400, 300);
        f.setVisible(true);
    }
}
