package it.unibo.mvc;

import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private final JFrame frame = new JFrame("My first graphical interface");

    private SimpleGUIWithFileChooser(final Controller contr){
        JPanel panel = new JPanel(new BorderLayout());
        frame.add(panel);
        JTextArea textArea = new JTextArea();
        JButton saveButton = new JButton("Save");
        panel.add(textArea, BorderLayout.CENTER);
        panel.add(saveButton, BorderLayout.SOUTH);
        JPanel panel2 = new JPanel(new BorderLayout());
        panel.add(panel2, BorderLayout.NORTH);
        JTextField txtField = new JTextField();
        JButton browseButton = new JButton("Browse...");
        panel2.add(txtField, BorderLayout.CENTER);
        panel2.add(browseButton, BorderLayout.LINE_END);
        txtField.setEditable(false);
        try {
            txtField.setText(contr.getPath());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ignored) {
                try {
                    contr.write(textArea.getText());
                } catch (IOException e) {
                    
                }
            }
        });
        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ignored){
                int out = -1;
                JFileChooser fileC = new JFileChooser();
                out = fileC.showSaveDialog(null);
                if(out == JFileChooser.APPROVE_OPTION){
                    contr.setFile(fileC.getSelectedFile().getAbsolutePath());
                    try {
                        txtField.setText(contr.getPath());
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }else if(out == JFileChooser.ERROR_OPTION){
                    JOptionPane.showMessageDialog(frame, "You chose a unsupported file", "Error", JOptionPane.ERROR_MESSAGE);
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
        final SimpleGUIWithFileChooser gui = new SimpleGUIWithFileChooser(new Controller());
        gui.display();
    }

}
