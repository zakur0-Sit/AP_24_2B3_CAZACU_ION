package org.example;

import java.awt.*;
import javax.swing.*;
public class Grid extends JPanel
{
    int cols = 7;
    int rows = 5;
    static int origX = 20;
    static int origY = 20;
    static int cellSize = 50;

    Grid(int rows, int cols)
    {
        this.rows = rows;
        this.cols = cols;
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        for (int i = 0; i < rows + 1; i++)
            g.drawLine(origX, origY + i * cellSize, origX + cols *cellSize, origY + i * cellSize);

        for (int i = 0; i < cols + 1; i++)
            g.drawLine(origX + i * cellSize, origY, origX + i * cellSize, origY + rows * cellSize);
    }
}
