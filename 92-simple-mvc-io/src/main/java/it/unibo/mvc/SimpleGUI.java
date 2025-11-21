package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame("My first graphical interface");

    private SimpleGUI(final Controller contr){
        JPanel panel = new JPanel(new BorderLayout());
        frame.add(panel);
        JTextArea textArea = new JTextArea();
        JButton saveButton = new JButton("Save");
        panel.add(textArea, BorderLayout.CENTER);
        panel.add(saveButton, BorderLayout.SOUTH);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ignored) {
                try {
                    contr.write(textArea.getText());
                } catch (IOException e) {
                    
                }
            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
    }

    private void display(){
        frame.setVisible(true);
    }

    public static void main(String args[]){
        final SimpleGUI gui = new SimpleGUI(new Controller());
        gui.display();
    }
}
