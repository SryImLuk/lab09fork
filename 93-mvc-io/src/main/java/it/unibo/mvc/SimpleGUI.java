package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * A very simple program using a graphical interface.
 *
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();

    public SimpleGUI(Controller cntr){
        JPanel panel = new JPanel(new BorderLayout());
        JTextArea txtArea = new JTextArea();
        JButton printButton = new JButton("Print");
        JButton historyButton = new JButton("Show history");
        frame.add(panel);
        panel.add(txtArea, BorderLayout.NORTH);
        panel.add(printButton, BorderLayout.WEST);
        panel.add(historyButton, BorderLayout.EAST);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        printButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ignore) {
                try {
                    cntr.nextString(txtArea.getText());
                    cntr.printString();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } 
        });
        historyButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ignore) {
                txtArea.setText("");
                for (String s : cntr.getHistory()) {
                    txtArea.append(s + "\t");
                }
            }
        });
        frame.pack();
        frame.setLocationByPlatform(true);
    }

    private void display(){
        frame.setVisible(true);
    }

    public static void main(String args[]){
        SimpleGUI gui = new SimpleGUI(new SimpleController());
        gui.display();
    }
}


