package org.example;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        SpinnerModel spinnerModel1 = new SpinnerNumberModel(0, 0, 15, 1);
        SpinnerModel spinnerModel2 = new SpinnerNumberModel(0, 0, 35, 1);
        JSpinner spinner1 = new JSpinner(spinnerModel1);
        JSpinner spinner2 = new JSpinner(spinnerModel2);

        JButton create = new JButton();
        JButton load = new JButton();
        JButton save = new JButton();
        JButton exit = new JButton();

        create.setText("Create");
        load.setText("Load");
        save.setText("Save");
        exit.setText("Exit");

        JLabel label = new JLabel();
        label.setText("Grid size:");

        JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();

        topPanel.setBackground(new Color(0xEEEEEE));
        bottomPanel.setBackground(new Color(0xEEEEEE));

        JFrame frame = new JFrame();
        frame.setTitle("My Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.setVisible(true);

        topPanel.add(label);
        topPanel.add(spinner1);
        topPanel.add(spinner2);
        topPanel.add(create);

        bottomPanel.add(load);
        bottomPanel.add(save);
        bottomPanel.add(exit);

        final int[] rows = {(int) spinner1.getValue()};
        final int[] cols = {(int) spinner2.getValue()};
        final Grid[] grid = {new Grid(rows[0], cols[0])};

        create.addActionListener(e -> {
            rows[0] = (int) spinner1.getValue();
            cols[0] = (int) spinner2.getValue();
            grid[0] = new Grid(rows[0], cols[0]);
            frame.getContentPane().removeAll();
            frame.add(topPanel, BorderLayout.NORTH);
            frame.add(bottomPanel, BorderLayout.SOUTH);
            frame.add(grid[0], BorderLayout.CENTER);
            frame.revalidate();
            frame.repaint();
        });

        save.addActionListener(e -> {
            if (grid[0] != null) {
                Component[] components = frame.getContentPane().getComponents();
                for (Component component : components) {
                    if (component instanceof Grid) {
                        ((Grid) component).saveAsPNG("grid.png");
                    }
                }
                try {
                    grid[0].serialize("grid.ser");
                    JOptionPane.showMessageDialog(frame, "Grid saved successfully.", "Save", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "Failed to save grid.", "Save Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Grid not created yet.", "Save Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        load.addActionListener(e -> {
            try {
                grid[0] = Grid.deserialize("grid.ser");
                frame.getContentPane().removeAll();
                frame.add(topPanel, BorderLayout.NORTH);
                frame.add(bottomPanel, BorderLayout.SOUTH);
                frame.add(grid[0], BorderLayout.CENTER);
                frame.revalidate();
                frame.repaint();
                JOptionPane.showMessageDialog(frame, "Grid loaded successfully.", "Load", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Failed to load grid.", "Load Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        exit.addActionListener(e -> {
            System.exit(0);
        });

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(bottomPanel, BorderLayout.SOUTH);
    }
}
