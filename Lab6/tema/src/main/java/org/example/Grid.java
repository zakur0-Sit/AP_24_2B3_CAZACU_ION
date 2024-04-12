package org.example;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Grid extends JPanel implements MouseListener, Serializable
{
    int cols = 7;
    int rows = 5;
    static int origX = 20;
    static int origY = 20;
    static int cellSize = 50;

    boolean[][] clicked;
    boolean[][][] thickLines;
    int counter = 0;
    int[][] circleColorMatrix = new int[rows + 1][cols + 1] ;

    Grid(int rows, int cols)
    {
        this.rows = rows;
        this.cols = cols;
        this.addMouseListener(this);
        clicked = new boolean[rows+1][cols+1];
        thickLines = generateRandomLines();
    }

    private boolean[][][] generateRandomLines() {
        boolean[][][] thickLines = new boolean[rows][cols][4];
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < 4; k++) {
                    thickLines[i][j][k] = random.nextBoolean();
                }
            }
        }
        return thickLines;
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.BLACK);

        super.paintComponent(g);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (thickLines[i][j][0]) {
                    g2D.setStroke(new BasicStroke(3));
                } else {
                    g2D.setStroke(new BasicStroke(1));
                }
                g.drawLine(origX + j * cellSize, origY + i * cellSize,
                        origX + (j + 1) * cellSize, origY + i * cellSize);

                if (thickLines[i][j][1]) {
                    g2D.setStroke(new BasicStroke(3));
                } else {
                    g2D.setStroke(new BasicStroke(1));
                }
                g.drawLine(origX + j * cellSize, origY + (i + 1) * cellSize,
                        origX + (j + 1) * cellSize, origY + (i + 1) * cellSize);

                if (thickLines[i][j][2]) {
                    g2D.setStroke(new BasicStroke(3));
                } else {
                    g2D.setStroke(new BasicStroke(1));
                }
                g.drawLine(origX + j * cellSize, origY + i * cellSize,
                        origX + j * cellSize, origY + (i + 1) * cellSize);

                if (thickLines[i][j][3]) {
                    g2D.setStroke(new BasicStroke(3));
                } else {
                    g2D.setStroke(new BasicStroke(1));
                }
                g.drawLine(origX + (j + 1) * cellSize, origY + i * cellSize,
                        origX + (j + 1) * cellSize, origY + (i + 1) * cellSize);
            }
        }

        for (int i = 0; i < rows + 1; i++) {
            for (int j = 0; j < cols + 1; j++) {
                int centerX = origX + j * cellSize;
                int centerY = origY + i * cellSize;
                g2D.setStroke(new BasicStroke(1));
                if (clicked[i][j])
                {
                    if(circleColorMatrix[i][j] == 1)
                    {
                        g2D.setColor(Color.BLUE);
                        g2D.fillOval(centerX - 7, centerY - 7, 15, 15);
                        g2D.setColor(Color.BLACK);
                        g2D.drawOval(centerX - 7, centerY - 7, 15, 15);
                    }
                    else if (circleColorMatrix[i][j] == 2)
                    {
                        g2D.setColor(Color.RED);
                        g2D.fillOval(centerX - 7, centerY - 7, 15, 15);
                        g2D.setColor(Color.BLACK);
                        g2D.drawOval(centerX - 7, centerY - 7, 15, 15);
                    }
                }
                else
                {
                    g2D.setColor(Color.WHITE);
                    g2D.fillOval(centerX - 7, centerY - 7, 15, 15);
                    g2D.setColor(Color.BLACK);
                    g2D.drawOval(centerX - 7, centerY - 7, 15, 15);
                }
            }
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();

        for (int i = 0; i < rows + 1; i++) {
            for (int j = 0; j < cols + 1; j++) {
                int centerX = origX + j * cellSize;
                int centerY = origY + i * cellSize;
                if (mouseX >= centerX - 5 && mouseX <= centerX + 5 && mouseY >= centerY - 5 && mouseY <= centerY + 5)
                {
                    clicked[i][j] = true;
                    counter++;
                    if(counter % 2 == 0  && circleColorMatrix[i][j] == 0)
                        circleColorMatrix[i][j] = 1;
                    else if(counter % 2 != 0  && circleColorMatrix[i][j] == 0)
                        circleColorMatrix[i][j] = 2;
                    else
                        counter--;
                    repaint();
                    return;
                }
            }
        }
    }

    public void saveAsPNG(String fileName) {
        BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();
        repaint();
        paintComponent(g2d);
        g2d.dispose();

        try {
            ImageIO.write(image, "PNG", new File(fileName));
            System.out.println("Imaginea a fost salvată ca " + fileName);
        } catch (IOException ex) {
            System.out.println("Eroare la salvarea imaginii: " + ex.getMessage());
        }
    }

    public void serialize(String fileName) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(this);
        }
    }

    public static Grid deserialize(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Grid) inputStream.readObject();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
