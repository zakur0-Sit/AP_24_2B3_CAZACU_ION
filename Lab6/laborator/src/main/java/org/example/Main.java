package org.example;

import javax.swing.*;
import java.awt.*;

public class Main
{
    public static void main(String[] args)
    {
        SpinnerModel spinerModel1 = new SpinnerNumberModel(0,0,15,1);
        SpinnerModel spinerModel2 = new SpinnerNumberModel(0,0,35,1);
        JSpinner spinner1 = new JSpinner(spinerModel1);
        JSpinner spinner2 = new JSpinner(spinerModel2);


        JButton create = new JButton();
        JButton load = new JButton();
        JButton save = new JButton();

        create.setText("Create");
        load.setText("Load");
        save.setText("Save");

        JLabel label = new JLabel();
        label.setText("Grid size:");

        JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();

        topPanel.setBackground(new Color(0xEEEEEE));
        bottomPanel.setBackground(new Color(0xEEEEEE));

        JFrame frame = new JFrame();
        frame.setTitle("My Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        frame.setVisible(true);

        topPanel.add(label);
        topPanel.add(spinner1);
        topPanel.add(spinner2);
        topPanel.add(create);

        bottomPanel.add(load);
        bottomPanel.add(save);

        create.addActionListener(e -> {
            int rows = (int) spinner1.getValue();
            int cols = (int) spinner2.getValue();
            frame.getContentPane().removeAll();
            frame.add(topPanel, BorderLayout.NORTH);
            frame.add(bottomPanel, BorderLayout.SOUTH);
            frame.add(new Grid(rows, cols), BorderLayout.CENTER);
            frame.revalidate();
            frame.repaint();
        });
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(bottomPanel, BorderLayout.SOUTH);
    }
}