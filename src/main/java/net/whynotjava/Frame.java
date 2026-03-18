package net.whynotjava;
import java.awt.*;

import javax.swing.*;

import net.whynotjava.Frame;

public class Frame extends JFrame{
    public static int SCALE = 75;
    public static int X_SCALE = 16;
    public static int Y_SCALE = 9;
    public Frame(){
        this.setPreferredSize(new Dimension(SCALE * X_SCALE, Y_SCALE * SCALE));
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.requestFocus();
        this.requestFocusInWindow();
        this.setTitle("Bluetooth File Tranfer - Whynotjava");
        this.setResizable(false);
        this.setLayout(BorderLayout);

        this.pack();

        buildUI();
    }
    public void buildUI(){
        JPanel infoPanel = new JPanel();
        // infoPanel.setMaximumSize(new Dimension(4*SCALE,Y_SCALE*SCALE));
        infoPanel.setMaximumSize(new Dimension(10,10));
        infoPanel.add(new JLabel("text"));

        infoPanel.setLocation(100,100);
        infoPanel.setBackground(Color.YELLOW);

        infoPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        this.add(infoPanel);
    }

    public static void main(String[] args) {
        new Frame();
    }
}