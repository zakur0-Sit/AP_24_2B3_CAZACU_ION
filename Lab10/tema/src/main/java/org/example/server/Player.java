package org.example.server;

import lombok.*;

import java.util.Random;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Player {

    private String name;
    private int[][] fleetMatrix = new int[10][10];

    public Player (String name) {
        this.name = name;
        createFleet();
    }

    private void createFleet() {
        int[][] matrix = createFleetMatrix();
        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                fleetMatrix[i - 1][j - 1] = matrix[i][j];
            }
        }
    }

    private int[][] createBoardedMatrix() {
        int[][] matrix = new int[12][12];
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                matrix[i][j] = 0;
            }
        }
        for (int i = 0; i < 12; i++) {
            matrix[i][0] = -1;
            matrix[0][i] = -1;
            matrix[i][11] = -1;
            matrix[11][i] = -1;
        }
        return matrix;
    }

    private int[][] createFleetMatrix() {
        int twoShip = 3;
        Random random = new Random();
        int[][] matrix = createBoardedMatrix();
        while (twoShip > 0) {
            for (int i = 1; i < 11; i++) {
                for (int j = 1; j < 11; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][j] = random.nextInt(2);
                    }
                    if (matrix[i][j - 1] == 1) {
                        matrix[i][j] = random.nextInt(2);
                        if (matrix[i][j] == 1) {
                            twoShip--;
                        } else {
                            matrix[i + 1][j] = 1;
                            twoShip--;
                        }
                    }
                    if (i != 1 && j != 1) {
                        if (matrix[i][j - 1] == 1 && matrix[i][j - 2] == 1) {
                            matrix[i][j] = 0;
                        }
                        if (matrix[i - 1][j] == 1 && matrix[i - 2][j] == 1) {
                            matrix[i][j] = 0;
                        }
                    }
                }
            }
            if (matrix == createBoardedMatrix()) {
                matrix[1][1]=1;
                matrix[1][2]=1;
                matrix[1][10]=1;
                matrix[2][10]=1;
                matrix[10][1]=1;
                matrix[10][2]=1;
                break;
            }
        }
        return matrix;
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder();
        print.append(name).append("\n");
        print.append("This is your fleet: \n");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                print.append(fleetMatrix[i][j]).append(" ");
            }
            print.append("\n");
        }
        return print.toString();
    }
}
